package com.myspring.service;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * xml形式的listener
 * created by xuyuan 18/9/4
 */
public class ConsumerListener
        //implements MessageListener
{


//    @Override
//    public void onMessage(Message message) {
//        TextMessage textMessage = (TextMessage) message;
//        try {
//            System.out.println("消费" + textMessage.getText());
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
//    }
}
