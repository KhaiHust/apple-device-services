package vn.edu.hust.project.appledeviceservice.config;

import static org.springframework.http.HttpMethod.GET;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import vn.edu.hust.project.appledeviceservice.property.RequestFilter;
import vn.edu.hust.project.appledeviceservice.security.JwtTokenFilter;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final RequestFilter requestFilter;

    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
                .csrf(AbstractHttpConfigurer::disable)
                 .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                 .authorizeHttpRequests(requests -> {
                     requests.requestMatchers("/ops/api/v1/auth/sign-up",
                             "/ops/api/v1/auth/login")
                             .permitAll()
                         .requestMatchers("/ops/api/v1/colors/**").hasRole("ADMIN")
                             .anyRequest().authenticated();
                 });
         return http.build();
    }
}
