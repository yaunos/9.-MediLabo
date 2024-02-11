package com.preventDiabet.PatientMicroservice.configuration;


import com.preventDiabet.PatientMicroservice.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
    @EnableWebSecurity
    public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

        private final UserDetailsServiceImpl userDetailsService;

        @Autowired
        public SpringSecurityConfig(UserDetailsServiceImpl userDetailsService) {
            this.userDetailsService = userDetailsService;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    // .authorizeRequests()
                    // .antMatchers("/**").permitAll()
                    // .and()
                    // .headers().defaultsDisabled().disable();

                    // .csrf().disable()

                    .authorizeRequests()
                     //   .antMatchers("/css/**", "/images/**", "/login.html", "/login", "/loginSuccess.html", "/loginFailure.html", "/web/**").permitAll()
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    //.oauth2Login()
                    //    .loginPage("/login.html")
                    //    .defaultSuccessUrl("/loginSuccess.html", true)
                    //    .failureUrl("/loginFailure.html")
                    //    .permitAll()
                    //.and()
                    .logout()
                    .permitAll();

        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception
        {
            auth.userDetailsService(userDetailsService);
        }
}

