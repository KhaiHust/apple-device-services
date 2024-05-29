package vn.edu.hust.project.appledeviceservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.property.JwtProperty;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenUtil {

    private final JwtProperty jwtProperty;

    public String generateToken(UserEntity user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        try {
            String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setExpiration(
                    new Date(System.currentTimeMillis() + jwtProperty.getExpiration() * 1000L))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
            return token;
        } catch (Exception e) {
            log.error("Error when generate token", e.getMessage());
            return null;
        }


    }

    private Key getSigninKey() {
        var bytes = Decoders.BASE64.decode(jwtProperty.getSecret());
        return Keys.hmacShaKeyFor(bytes);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token)
            .getBody();
    }

    private <T> T extractClaim(String token, Function<Claims, T> resolver) {
        final var claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    //check expiration
    private Boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}
