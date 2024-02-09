/*
package com.preventdiabet.DoctorsNotesMicroService.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;



@Configuration
@EnableWebSecurity

public static class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  http
          .authorizeHttpRequests((authz) -> authz
                  .anyRequest().authenticated()
          )
          .httpBasic(withDefaults());
  return http.build();
}
}





    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable(); // Désactiver la protection CSRF
    }
}
*/
