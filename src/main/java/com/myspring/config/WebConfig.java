package com.myspring.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * created by xuyuan 18/8/18
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.myspring")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 异常转换
     * @return
     */
    @Bean
    public BeanPostProcessor postProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
