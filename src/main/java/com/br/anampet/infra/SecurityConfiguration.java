package com.br.anampet.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration //Mapeia para o spring como uma classe de configuração
@EnableWebSecurity //Habilita a classe realizar ações sobre web security
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter; //Classe criada para validar o token nos requests

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {                //cria um canal de filtro de segurança
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))                     //muda a forma que a sessão é mantida
                .authorizeHttpRequests(req -> {                                                                         //define quais regras para requisições
                    req.requestMatchers(HttpMethod.POST, "/login").permitAll();                               //permite todos post requests para /login
                    req.requestMatchers(HttpMethod.POST, "/usuario").permitAll();
                    req.requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll(); //permite todos requests para o swagger
                    req.anyRequest().authenticated();                                                                   //Define que para qualquer outro request seja necessario autenticar
                }).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)                          //define que o filtro executado seja do SecurityFilter
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception { //retorna um gerenciador de autenticação
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //retorna um encoder para encriptar a senha
        return new BCryptPasswordEncoder();
    }

}