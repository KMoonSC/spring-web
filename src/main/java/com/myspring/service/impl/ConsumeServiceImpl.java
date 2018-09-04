package com.myspring.service.impl;

import com.myspring.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * created by xuyuan 18/9/3
 */
@Service
public class ConsumeServiceImpl implements ConsumeService {

//    @Autowired
//    private JmsTemplate jmsTemplate;
//    @Autowired
//    @Qualifier("activeMQQueue")
//    private Destination activeMQQueue;

    //@Scheduled(fixedDelay = 2000)
//    public void receive() {
//        // 这种方式会阻塞至连接超时，获取到null
//        System.out.println((String)jmsTemplate.receiveAndConvert(activeMQQueue));
//    }

    @JmsListener(containerFactory = "jmsListenerContainerFactory", destination = "productQueue")
    public void receive(String product) {
        System.out.println("消费" + product);
    }
}
