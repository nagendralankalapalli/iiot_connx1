package com.beauto.iiotconnx.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//
//import com.beauto.iiotconnx.servicesimpl.CustomUserDetailsService;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private CustomUserDetailsService userDetailsService;
//
//	@Autowired
//	private JwtFilter jwtFilter;
//
//	@Autowired
//	private JwtAuthenticationEntryPoint entryPoint;
//	@Autowired
//	private AccessDeniedHandler accessDeniedHandler;
//
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(userDetailsService);
////	}
//
//	protected void configures(HttpSecurity http) throws Exception {
//		// ...
//		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(); // You can use other encoders like BCrypt, Argon2, etc.
//	}
//
//	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.csrf().disable().authorizeRequests()
////				.antMatchers(  "/login", "/register")
////				.permitAll().
////				antMatchers().hasRole("USER") // Assuming 'USER' is a role in your
////																					// system
////				.antMatchers().hasRole("ADMIN") // Assuming 'ADMIN' is a role in your system
////				.anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(entryPoint)
////				.accessDeniedHandler(accessDeniedHandler).and().sessionManagement()
////				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
////				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).formLogin().disable();
////	}
////
////	 @Override
////	    protected void configure1(AuthenticationManagerBuilder auth) throws Exception {
////	        // Configure in-memory authentication with multiple roles
////	        auth.inMemoryAuthentication()
////	            .withUser("admin").password("{noop}admin").roles("ADMIN")
////	            .and()
////	            .withUser("user").password("{noop}user").roles("USER");
////	    }
//	@Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // Configure in-memory authentication with multiple roles
//       // auth.inMemoryAuthentication()
//        auth.userDetailsService(userDetailsService);
//            .withUser("admin").password("{noop}admin").roles("ADMIN")
//            .and()
//            .withUser("user").password("{noop}user").roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/admin/**").hasRole("ADMIN") // Access restricted to users with ADMIN role
//            .antMatchers("/user/**").hasRole("USER")   // Access restricted to users with USER role
//            .anyRequest().authenticated()              // All other requests require authentication
//            .and()
//            .formLogin()                               // Enable form-based login
//            .and()
//            .httpBasic();                              // Enable basic authentication
//    }
//
//}



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.beauto.iiotconnx.servicesimpl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/register","/addRole").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint).accessDeniedHandler(accessDeniedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}


