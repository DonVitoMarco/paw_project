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
    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        OWN IMPLEMENTATION
        auth.userDetailsService(authenticationService);

//        DATABASE AUTHENTICATION CONFIG
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("SELECT user.username, user.password, user.enabled FROM user WHERE user.username = ?")
//                .authoritiesByUsernameQuery("SELECT role.user_username, role.roleName FROM role WHERE role.user_username = ?");
//                .authoritiesByUsernameQuery("SELECT user.username, role.roleName FROM role JOIN user ON user.username = role.user_username WHERE user_username = ?");
//                .passwordEncoder(passwordEncoder());

//        MEMORY AUTHENTICATION CONFIG
//         auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//         auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/profile").access("hasRole('ROLE_USER')")

//                .and().formLogin().loginPage("/login").permitAll()
                .and().formLogin().permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")

                .and().csrf();
    }

}