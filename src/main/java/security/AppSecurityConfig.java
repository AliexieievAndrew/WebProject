package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

// filter mapping and filter in xml

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    // authentication manager in xml
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // test security
        auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").access("hasRole('ROLE_ADMIN')")
                .and().formLogin()

                // if second @param is false, when user successfully authorized,
                // redirect him to the page where he came from
                .defaultSuccessUrl("/", false);
    }
}
