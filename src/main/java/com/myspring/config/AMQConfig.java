package com.myspring.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJcaListenerContainerFactory;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

/**
 * created by xuyuan 18/9/3
 */
@Configuration
@PropertySource({"classpath:application.properties"})
public class AMQConfig {

    @Value("${activemq.broker-url}")
    private String brokerUrl;

    @Value("${activemq.in-memory}")
    private String inMemory;

    @Value("${activemq.username}")
    private String username;

    @Value("${activemq.password}")
    private String password;

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory();
        mqConnectionFactory.setBrokerURL(brokerUrl);//mq的服务器地址
        mqConnectionFactory.setUserName(username);//用户名
        mqConnectionFactory.setPassword(password);//密码
        return mqConnectionFactory;
    }

//    @Bean
//    public Destination activeMQQueue() {
//        ActiveMQQueue activeMQQueue = new ActiveMQQueue();
//        activeMQQueue.setPhysicalName("productQueue");
//        return activeMQQueue;
//    }

//    @Bean
//    public JmsTemplate jmsTemplate() {
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setConnectionFactory(connectionFactory());
//        jmsTemplate.setDefaultDestination(activeMQQueue());
//        jmsTemplate.setReceiveTimeout(10000);
//        return jmsTemplate;
//    }

    // 这个根本不需要
//    @Bean
//    public MessageConverter jmsMessageConverter() {
//       return new SimpleMessageConverter();
//    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        //设置连接数
        factory.setConcurrency("3-10");
        //重连间隔时间
        factory.setRecoveryInterval(1000L);
        return factory;
    }
}
