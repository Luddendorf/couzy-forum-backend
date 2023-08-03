package com.breeze.summer;

import com.breeze.summer.filters.JwtRequestFilter;
import com.breeze.summer.services.oauth2.OAuth2FailureHandler;
import com.breeze.summer.services.oauth2.OAuth2SuccessHandler;
import com.breeze.summer.services.oauth2.OAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@EnableWebSecurity
// @EnableGlobalMethodSecurity(
// prePostEnabled = true
// // securedEnabled = true,
// // jsr250Enabled = true
// )
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // Configuring Authentication
    @Autowired
    private final UserDetailsService authUserDetailsService;
    @Autowired
    private final OAuth2UserService oAuth2UserService;
    @Autowired
    private final JwtRequestFilter jwtRequestFilter;
    @Autowired
    private final OAuth2FailureHandler oAuth2FailureHandler;
    @Autowired
    private final OAuth2SuccessHandler oAuth2SuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authUserDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // Configuring Authorisation

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(new AuthEntryPoint())
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // telling spring security to not create a
                                                                        // session
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/users/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/post").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(oAuth2UserService)
                .and()
                .successHandler(oAuth2SuccessHandler)
                .failureHandler(oAuth2FailureHandler);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // telling spring security
                                                                                            // to make sure that our
                                                                                            // jwtreqfilter is called
                                                                                            // before the username and
                                                                                            // pwd auth filter is called
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
