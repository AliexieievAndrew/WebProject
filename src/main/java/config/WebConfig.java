package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc

@ComponentScan(basePackages = {"controller","exception"})
public class WebConfig extends WebMvcConfigurerAdapter {

    // loading static resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/assets/");
    }

    @Bean
    public ViewResolver getViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        // for using form
        resolver.setExposeSpringMacroHelpers(true);
        resolver.setExposeRequestAttributes(true);

        //main
        resolver.setOrder(1);
        resolver.setSuffix(".ftl");
        resolver.setPrefix("");
        return resolver;
    }

    @Bean
    FreeMarkerConfigurer getFreeMarkerConfigurer () {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPaths("/", "/WEB-INF/views/"); //<artifactId>spring-context-support</artifactId>
        return freeMarkerConfigurer;
    }

    // for upload file (only name multipartResolver) !!!!!!!!!!
    @Bean
    MultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSizePerFile(2097152L);
        return commonsMultipartResolver;
    }
}
