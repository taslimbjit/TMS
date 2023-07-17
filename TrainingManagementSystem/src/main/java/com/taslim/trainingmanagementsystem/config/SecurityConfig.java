package com.taslim.trainingmanagementsystem.config;

<<<<<<< HEAD

import com.taslim.trainingmanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
=======
import com.taslim.trainingmanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
>>>>>>> 5b590c25ac9b4380c4b497dd99f2bb78c55f3cba
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

<<<<<<< HEAD

=======
>>>>>>> 5b590c25ac9b4380c4b497dd99f2bb78c55f3cba
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserRepository userRepository;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
<<<<<<< HEAD
                .requestMatchers("/admin/register","admin/login")
                .permitAll()
                .requestMatchers("/trainer/register","/Trainee/register"
                        ,"/trainees/create","/admins/create","/trainers/create","/batches/create","/courses/create"
                        ,"/batch-schedules/create","/assign-trainer/assign","/assign-trainees/create","/trainees/all"
                        ,"/trainers/all","/batches/all","/courses/all","/batch-schedules/all","/trainees/id/**","/trainers/id/**"
                        ,"/batches/id/**","/courses/id/**","/batch-schedules/id/**","/trainees/update/**","/trainers/update/**"
                        ,"/batches/update/**","/courses/update/**","/assign-trainees/update/**","/assign-trainer/update/**"
                        ,"/trainees/delete/**","/trainers/delete/**","/batches/delete/**","/courses/delete/**")
                .hasAnyAuthority("ADMIN")

                .requestMatchers("/trainer/login","/assignments/create","/assignments/all","/batch-schedules/all"
                        ,"/assignment-submissions/all","/batches/id/**","/courses/id/**","/assignments/id/**","/batch-schedules/id/**"
                        ,"/assignment-submissions/id/**")
                .hasAnyAuthority("TRAINER")

                .requestMatchers("/trainee/login","/assignment-submissions/create","/batch-schedules/all"
                        ,"/courses/id/**","/batch-schedules/id/**","/assignment-submissions/id/**")
                .hasAnyAuthority("TRAINEE")
=======
                .requestMatchers("/user/register","user/login")
                .permitAll()
                .requestMatchers("/books/author/**","/books/id/**","/books/all")
                .hasAnyAuthority("ADMIN","CUSTOMER")
                .requestMatchers("/books/create","/books/update/**","/books/delete/**","/books/**")
                .hasAuthority("ADMIN")
>>>>>>> 5b590c25ac9b4380c4b497dd99f2bb78c55f3cba
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }
}
