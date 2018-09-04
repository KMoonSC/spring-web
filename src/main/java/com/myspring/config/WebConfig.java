package com.myspring.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * created by xuyuan 18/8/18
 */
@Configuration
@EnableJms
@EnableWebMvc
@EnableScheduling
@ComponentScan("com.myspring")
@ImportResource("classpath:AMQConfig.xml")
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
