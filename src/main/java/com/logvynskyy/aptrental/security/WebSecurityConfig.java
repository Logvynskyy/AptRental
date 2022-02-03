package com.logvynskyy.aptrental.security;

import com.logvynskyy.aptrental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebSecurity
//@ComponentScan("com.logvynskyy.aptrental.security")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    final
    UserService userService;

    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//    @Autowired
//    private CustomAuthenticationProvider authProvider;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider);
//    }

//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
//    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new InMemoryUserDetailsManager(
//                User.builder().username("user").password(bCryptPasswordEncoder().encode(
//                        "user123")).roles("USER").build()
//        );
//    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                    //Доступ только для не зарегистрированных пользователей
                    .antMatchers("/registration").not().fullyAuthenticated()
                    .antMatchers("/addApartment", "/editApartment", "/apartment", "/main").fullyAuthenticated()
                    //Доступ разрешен всем пользователей
                    .antMatchers("/").permitAll()
                .and()
                    .formLogin()
                    .defaultSuccessUrl("/main")
                    .permitAll()
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .permitAll()
                    .logoutSuccessUrl("/");
    }
}
