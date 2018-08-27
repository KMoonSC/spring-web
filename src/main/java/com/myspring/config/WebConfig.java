package com.myspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * created by xuyuan 18/8/18
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.myspring")
public class WebConfig extends WebMvcConfigurerAdapter {

}
