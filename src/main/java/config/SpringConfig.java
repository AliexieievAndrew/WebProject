package config;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    CategoryDAO getCategoryDAO(){
        return new CategoryDAOImpl();
    };
}
