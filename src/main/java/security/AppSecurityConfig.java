package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

// filter mapping and filter in xml
// example https://www.boraji.com/spring-security-5-jdbc-based-authentication-example
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    // from HibernateConfig.class
    @Autowired
    private DataSource dataSource;

    // authentication manager in xml
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("SELECT email, password, enabled FROM user_detail WHERE email = ?")
            .authoritiesByUsernameQuery("SELECT email, role FROM user_detail WHERE email = ?")
            .passwordEncoder(NoOpPasswordEncoder.getInstance()); // Temporary
//                inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").hasAuthority("USER")
//                .antMatchers("/**").access("hasRole('ROLE_USER')")
                .and().formLogin()

                // if second @param is false, when user successfully authorized,
                // redirect him to the page where he came from
                .defaultSuccessUrl("/", false);
    }
}
