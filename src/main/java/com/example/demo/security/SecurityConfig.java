package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
		//CONFIGURACIÓN POR DEFECTO - PIDE QUE TODOS LOS ENDPOINT ESTEN PROTEGIDOS (anyRequest().authenticated)
//		@Bean
//		SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//			http.authorizeHttpRequests(auth -> 
//				auth.anyRequest().authenticated())
//			.formLogin(Customizer.withDefaults())
//			.httpBasic(Customizer.withDefaults());
//			return http.build();
//		}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(auth ->
			// Endpoint protegidos.
			auth.requestMatchers("/raza", "/mascota").authenticated()
			// Todos los demas endpoint no estarán protegidos.	
			.anyRequest().permitAll())
		//Esta linea me permite ejecutar una peticion cliente dentro del mismo host (me daba problemas si no la incluia)
		.csrf(csrf -> csrf.disable())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		return httpSecurity.build();
	}
	
	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails admin = User.withUsername("admin")
				.password("to_be_encoded")
				.authorities("ADMIN")
				.build();
		
		UserDetails user = User.withUsername("user")
				.password("to_be_encoded")
				.authorities("ROLE_ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(admin, user);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
