package pl.thewalkingcode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.thewalkingcode.service.security.AuthenticationService;

@Configuration
@EnableWebSecurity
@ComponentScan({"pl.thewalkingcode.*"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationService authenticationService;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        OWN IMPLEMENTATION DATABASE AUTH
        auth.userDetailsService(authenticationService);

//        MEMORY AUTHENTICATION CONFIG
//         auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//         auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requiresChannel().anyRequest().requiresSecure();

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/profile").access("hasRole('ROLE_USER')")
                .antMatchers("/profile/*").access("hasRole('ROLE_USER')")
                .antMatchers("/panel").access("hasRole('ROLE_USER')")
                .antMatchers("/panel/*").access("hasRole('ROLE_USER')")

//               OWN LOGIN PAGE
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")

                .and().csrf();
    }

}