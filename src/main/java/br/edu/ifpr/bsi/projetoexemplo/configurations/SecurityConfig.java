package br.edu.ifpr.bsi.projetoexemplo.configurations;

import br.edu.ifpr.bsi.projetoexemplo.enums.Role;
import br.edu.ifpr.bsi.projetoexemplo.components.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    // Exporta o AuthenticationManager para podermos usá-lo no AuthController
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) {
        return configuration.getAuthenticationManager();
    }

    // Define o algoritmo de Hash para as senhas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(this::configurarAutorizacoes)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(java.util.List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    private void configurarAutorizacoes(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry req) {

        // Permitir acesso público
        req.requestMatchers("/error").permitAll();
        req.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
        req.requestMatchers(HttpMethod.POST, "/auth", "/clientes").permitAll();
        req.requestMatchers(HttpMethod.GET, "/produtos", "/produtos/**").permitAll();

        // Exigir autenticação como FUNCIONARIO ou ADMIN
        req.requestMatchers(HttpMethod.GET, "/clientes", "/clientes/**", "/pedidos", "/pedidos/**").hasAnyAuthority(Role.ADMIN.name(), Role.FUNCIONARIO.name());
        req.requestMatchers(HttpMethod.POST, "/produtos").hasAnyAuthority(Role.ADMIN.name(), Role.FUNCIONARIO.name());
        req.requestMatchers(HttpMethod.PUT, "/clientes/**", "/pedidos/**", "/produtos/**").hasAnyAuthority(Role.ADMIN.name(), Role.FUNCIONARIO.name());
        req.requestMatchers(HttpMethod.PATCH, "/clientes/**", "/pedidos/**", "/produtos/**").hasAnyAuthority(Role.ADMIN.name(), Role.FUNCIONARIO.name());

        // Exigir autenticação como ADMIN
        req.requestMatchers(HttpMethod.GET, "/funcionarios", "/funcionarios/**").hasAuthority(Role.ADMIN.name());
        req.requestMatchers(HttpMethod.POST, "/funcionarios").hasAuthority(Role.ADMIN.name());
        req.requestMatchers(HttpMethod.PUT, "/funcionarios/**").hasAuthority(Role.ADMIN.name());
        req.requestMatchers(HttpMethod.PATCH, "/funcionarios/**").hasAuthority(Role.ADMIN.name());
        req.requestMatchers(HttpMethod.DELETE).hasAuthority(Role.ADMIN.name());

        // Qualquer outra requisição não listada acima PRECISA estar autenticada
        req.anyRequest().authenticated();
    }
}
