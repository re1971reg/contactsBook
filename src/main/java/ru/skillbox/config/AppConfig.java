package ru.skillbox.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@ComponentScan("ru.skillbox")
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        System.out.println("create properties bean ...");
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new ClassPathResource("application.yaml"));
        configurer.setProperties(yamlPropertiesFactoryBean.getObject());
        return configurer;
    }

}
