package vn.edu.hust.project.appledeviceservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class CorsConfig implements WebMvcConfigurer {
    private final CorsProperties corsProperties;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        List<String> allowedMethods = corsProperties.getAllowedMethods();
        registry.addMapping("/**")
                .allowedOrigins(corsProperties.getBaseUrl())
                .allowedMethods(allowedMethods.toArray(new String[0]))
                .allowedHeaders("*");
    }
}
