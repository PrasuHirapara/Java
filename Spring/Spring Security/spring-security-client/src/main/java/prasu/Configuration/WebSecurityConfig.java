package prasu.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {

    private static final String[] WHITE_LIST_ARRAY = {
            "/hello",
            "/login",
            "/register",
            "/verifyRegistration*",
            "/resendVerifyToken*",
            "/savePassword*",
            "/resetPassword*",
            "/changePassword"
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(WHITE_LIST_ARRAY).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
