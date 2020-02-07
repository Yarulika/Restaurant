package com.sda.restaurant.config;

import com.sda.restaurant.service.UserService;
import com.sda.restaurant.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// TODO: will reconfigure
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder(); }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override // WebSecurity = ignoring() method: this will omit the request pattern from the security filter chain entirely (! no authentication or authorization services applied)
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**");
//        web.ignoring().antMatchers("/restaurant/persons/**");
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/employees/**").hasAnyRole("employee")
                    .anyRequest().hasAnyRole("customer")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/hi")
                .permitAll();


//        http
//            .authorizeRequests()
//                .antMatchers(
//                        "/persons",
//                        "/test",
////                        "/registration**",
//                        "/js/**").permitAll()
//                .anyRequest().anonymous()//.authenticated()
//                .and()
//            .formLogin()
////                .loginPage("/login")
////                .permitAll()
//                .and()
//            .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout")
//                .permitAll();
    }



}
