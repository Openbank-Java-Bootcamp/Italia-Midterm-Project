package com.ironhack.bankingsystem.security;

import com.ironhack.bankingsystem.secureUtils.filters.CustomAuthenticationFilter;
import com.ironhack.bankingsystem.secureUtils.filters.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/banking/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/banking/login/**").permitAll();
        http.authorizeRequests().antMatchers(POST, "/banking/accounts/**").hasAnyAuthority("ROLE_ADMIN");

        //        http.authorizeRequests().antMatchers(GET, "/banking/accounts/**/balance/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/banking/accounts/checkings/balance/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/banking/accounts/creditcards/balance/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/banking/accounts/savings/balance/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/banking/accounts/student-checkings/balance/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PATCH, "/banking/accounts/checkings/balance/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PATCH, "/banking/accounts/creditcards/balance/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PATCH, "/banking/accounts/savings/balance/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PATCH, "/banking/accounts/student-checkings/balance/**").hasAnyAuthority("ROLE_ADMIN");

        http.authorizeRequests().antMatchers(POST, "/banking/users/third-party").hasAnyAuthority("ROLE_ADMIN");
        /*http.authorizeRequests().antMatchers(GET, "/api/posts/**").permitAll();
        http.authorizeRequests().antMatchers(GET, "/api/authors/**").permitAll();
        http.authorizeRequests().antMatchers(POST, "/api/posts").hasAnyAuthority("ROLE_ADMIN", "ROLE_CONTRIBUTOR");
        http.authorizeRequests().antMatchers(POST, "/api/authors").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(POST, "/api/users").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PUT, "/api/posts").hasAnyAuthority("ROLE_ADMIN", "ROLE_CONTRIBUTOR");
        http.authorizeRequests().antMatchers(PUT, "/api/authors").hasAnyAuthority("ROLE_ADMIN", "ROLE_CONTRIBUTOR");
        http.authorizeRequests().antMatchers(DELETE, "/api/posts").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(DELETE, "/api/authors").hasAnyAuthority("ROLE_ADMIN");*/
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
