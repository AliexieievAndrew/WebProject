package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

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
//            .passwordEncoder(NoOpPasswordEncoder.getInstance()); // Temporary
                .passwordEncoder(new BCryptPasswordEncoder()); // Temporary
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // only admin
                .antMatchers("/manage/**").hasAuthority("ADMIN")

                // only user
                .antMatchers("/cart/**").hasAuthority("USER")


                // rest
                .antMatchers("/register","/login").anonymous()
                .antMatchers("/**").permitAll()
                .and().formLogin()
                .loginPage("/login")
                .permitAll()

                // if second @param is false, when user successfully authorized,
                // redirect him to the page where he came from
                .defaultSuccessUrl("/", false).and()

                // AccessDeniedException
                .exceptionHandling().accessDeniedPage("/accessDenied").and()

                // If users will not be using application in a web
                .csrf().disable()
        ;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

}
