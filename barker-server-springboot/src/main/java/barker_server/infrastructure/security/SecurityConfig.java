package barker_server.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final JwtAuthenticationFilter jwtFilter;

  public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
    this.jwtFilter = jwtFilter;
  }

  @Bean
  public BCryptPasswordEncoder bcryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/users").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/health/**").permitAll()
            .anyRequest().authenticated())
        // .exceptionHandling(ex -> ex
        // .authenticationEntryPoint((request, response, authException) -> {
        // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        // })) without this, it throws 403 instead of 401 when the user is not
        // authenticated. This is because by default, Spring Security returns 403 for
        // unauthenticated requests that require authentication. By setting a custom
        // AuthenticationEntryPoint, we can change this behavior to return 401 instead.
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }

}
