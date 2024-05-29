package vn.edu.hust.project.appledeviceservice.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)  {
        try {
            if(isByPassToken(request)) {
                filterChain.doFilter(request, response);
            }
            final String authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                throw new HttpClientErrorException.Unauthorized();
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }



    }

    private boolean isByPassToken(
            @NonNull HttpServletRequest request
    ) {
        final List<Pair<String, String>> bypassToken =
                Arrays.asList(
                        Pair.of("/ops/api/v1/auth/sign-up", "POST"),
                        Pair.of("/ops/api/v1/auth/login", "POST")
                );
        for (var byPassToken : bypassToken) {
            if (request.getRequestURI().equals(byPassToken.getFirst()) && request.getMethod().equals(byPassToken.getSecond())) {
                return true;
            }
        }
        return false;
    }
}
