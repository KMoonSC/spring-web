package com.myspring.config;

import com.myspring.service.HessianTestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

/**
 * created by xuyuan 18/8/31
 */
@Configuration
public class RPCConfig {

    @Value("${serve.url}")
    private String serveUrl;

    @Bean
    public HessianProxyFactoryBean HessianClient() {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
        factory.setServiceUrl(serveUrl + "hessianService");
        factory.setServiceInterface(HessianTestService.class);
        return factory;
    }

}
