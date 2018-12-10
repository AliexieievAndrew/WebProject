package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;

import java.util.Collections;


// link config webflow for example
// https://docs.spring.io/spring-webflow/docs/current/reference/html/system-setup.html
// https://github.com/spring-projects/spring-webflow-samples/blob/master/booking-mvc/src/main/java/org/springframework/webflow/samples/booking/config/WebMvcConfig.java
// https://github.com/spring-projects/spring-webflow-samples/blob/master/booking-mvc/src/main/java/org/springframework/webflow/samples/booking/config/WebFlowConfig.java
@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

    @Autowired
    private WebConfig webConfig;

    @Bean
    public FlowDefinitionRegistry flowRegistry() {
        return getFlowDefinitionRegistryBuilder(flowBuilderServices())
                // in case if i dont want to use path i can use following for indicating the flow file and its ID
                // .addFlowLocation("/WEB-INF/flows/signup-flow.xml")

                // shows where need to look
                .setBasePath("/WEB-INF/views/flows")

                // /**/*-flow.xml - where
                // for example registry
                // /**/ - id (id = registry)
                // /*-flow.xml - file (signup-flow.xml)
                .addFlowLocationPattern("/**/*-flow.xml")
                .build();
    }

    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowRegistry()).build();
    }

    @Bean
    public FlowBuilderServices flowBuilderServices() {
        return getFlowBuilderServicesBuilder()
                .setViewFactoryCreator(mvcViewFactoryCreator())
                .setValidator(validator())
                .setDevelopmentMode(true)
                .build();
    }

    @Bean
    public MvcViewFactoryCreator mvcViewFactoryCreator() {
        MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
        factoryCreator.setViewResolvers(Collections.singletonList(this.webConfig.getViewResolver()));
        factoryCreator.setUseSpringBeanBinding(true);
        return factoryCreator;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}
