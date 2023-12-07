package com.proj.tech.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    public static final String ROLE_USER = "USER";
    public static final String ROLE_PROFESSOR = "PROFESSOR";
    public static final String ROLE_ADMIN = "ADMIN";

    /*@Bean
    public UserDetailsService userDetailsService() {
        // We create a password encoder
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password(encoder.encode("password")).roles(ROLE_USER).build());
        manager.createUser(User.withUsername("prof").password(encoder.encode("password")).roles(ROLE_PROFESSOR).build());
        manager.createUser(User.withUsername("admin").password(encoder.encode("admin")).roles(ROLE_ADMIN).build());
        return manager;
    }

     */

//    @Bean
//    @Order(SecurityProperties.BASIC_AUTH_ORDER)
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
//        return http.build();
//    }

//    @Bean
//    @Order(1)
//    public SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((requests) ->
//                        requests
//                                .requestMatchers(AntPathRequestMatcher.antMatcher("/mainPage.html")).hasRole(ROLE_ADMIN)
////                                .anyRequest().authenticated()
//                );
////                .exceptionHandling(exceptionHandling -> exceptionHandling
////                    .authenticationEntryPoint((request, response, authException) -> response.sendRedirect("/choose"))
////                );
//        return http.build();
//    }

    /*@Bean
    @Order(2)
    public SecurityFilterChain basicFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/login.html")).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login.html")
                        .defaultSuccessUrl("/mainPage.html", true)
                        .permitAll()
                        .loginProcessingUrl("/login")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .deleteCookies("JSESSIONID")
                )
                .httpBasic(withDefaults());
//                .exceptionHandling(exceptionHandling -> exceptionHandling
//                    .authenticationEntryPoint((request, response, authException) -> response.sendRedirect("/choose"))
//                );
        return http.build();
    }

     */
}
