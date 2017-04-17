package pl.thewalkingcode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan({"pl.thewalkingcode.*"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("SELECT user.username, user.password, user.enabled FROM user WHERE user.username = ?")
//                .authoritiesByUsernameQuery("SELECT user.username, role.roleName FROM role JOIN user ON user.username = role.user_username WHERE user_username = ?");
//                .passwordEncoder(passwordEncoder());

         auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
         auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/profile").access("hasRole('ROLE_USER')")
                .antMatchers("/register").permitAll()
                .antMatchers("/").permitAll()

                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll()
                .and().csrf();
    }

}