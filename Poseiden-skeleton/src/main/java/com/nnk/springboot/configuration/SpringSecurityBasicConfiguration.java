package com.nnk.springboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityBasicConfiguration {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    /**
     * Configure le filtre de sécurité pour gérer les requêtes HTTP.
     * Définit les règles d'autorisation basées sur les rôles des utilisateurs et les mécanismes d'authentification.
     *
     * @param http l'objet HttpSecurity utilisé pour configurer les paramètres de sécurité
     * @return un objet SecurityFilterChain représentant le filtre de sécurité configuré
     * @throws Exception si une erreur se produit lors de la configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/admin").hasRole("ADMIN");
                    auth.requestMatchers("/user").hasRole("USER");
                    auth.anyRequest().authenticated();
                }).formLogin(Customizer.withDefaults())
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/app-logout"))
                        .permitAll()
                        .logoutSuccessUrl("/home"))
                .build();
    }

    /**
     * Fournit une instance de BCryptPasswordEncoder pour encoder les mots de passe.
     *
     * @return un objet BCryptPasswordEncoder pour l'encodage des mots de passe
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configure l'AuthenticationManager avec un service de détails utilisateur personnalisé et un encodeur de mots de passe.
     *
     * @param http            l'objet HttpSecurity utilisé pour configurer les paramètres de sécurité
     * @param passwordEncoder l'objet BCryptPasswordEncoder utilisé pour l'encodage des mots de passe
     * @return un objet AuthenticationManager configuré avec le service de détails utilisateur et l'encodeur de mots de passe spécifiés
     * @throws Exception si une erreur se produit lors de la configuration
     */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }
}
