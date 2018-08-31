package com.myspring.config;

import com.myspring.service.HessianTestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

/**
 * created by xuyuan 18/8/31
 */
@Configuration
public class RPCConfig {

    @Bean
    public HessianProxyFactoryBean HessianClient() {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
        factory.setServiceUrl("http://localhost:8180/hessianService");
        factory.setServiceInterface(HessianTestService.class);
        return factory;
    }

}
