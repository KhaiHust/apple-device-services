package vn.edu.hust.project.appledeviceservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.port.IRolePort;
import vn.edu.hust.project.appledeviceservice.port.IUserPort;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    private final UserEntity userEntity;
    private final Collection<? extends GrantedAuthority> authorities;
    private final IUserPort userPort;

    private final IRolePort rolePort;

    public CustomUserDetails(UserEntity userEntity, IUserPort userPort, IRolePort rolePort) {
        this.userEntity = userEntity;
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));
        this.userPort = userPort;
        this.rolePort = rolePort;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //TODO: get role from db
//        var role = rolePort.getRoleById(userEntity.getRoleId());
//        return Collections.singleton(new SimpleGrantedAuthority(role.getCode()));
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
