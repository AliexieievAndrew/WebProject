package config;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"dto","dao"})
@EnableTransactionManagement
public class HibernateConfig {
    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;database=Delivery";
    private static final String DATABASE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_DIALECT = "org.hibernate.dialect.SQLServerDialect";
    private static final String DATABASE_USERNAME = "admin";
    private static final String DATABASE_PASSWORD = "12345";


    @Bean
    public CategoryDAO getCategoryDAO(){
        return new CategoryDAOImpl();
    };

    @Bean
    public ProductDAO getProductDAO(){
        return new ProductDAOImpl();
    }

    // dbcp lib(maven)
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        // providing the database connection information
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);

        return dataSource;
    }

    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
        localSessionFactoryBuilder.addProperties(getHibernateProperties());

        localSessionFactoryBuilder.scanPackages("dto");

        return localSessionFactoryBuilder.buildSessionFactory();
    }

    // all hibernate properties will be get here
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", DATABASE_DIALECT);
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);

        return properties;
    }

    // transaction manager
    @Bean
    public HibernateTransactionManager getTransactionManager (SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }
    @Bean
    public CategoryService getCategoryService() {
        return new CategoryServiceImpl();
    }

    @Bean
    public ProductService getProductService(){
        return new ProductServiceImpl();
    }
}
