package com.myspring.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import static org.springframework.web.context.ContextLoader.getCurrentWebApplicationContext;

/**
 * created by xuyuan 18/9/4
 */
@Component
public class Publisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //this.applicationContext = applicationContext;如果是这样onApplicationEvent会执行两次
        this.applicationContext = ContextLoader.getCurrentWebApplicationContext();
    }

    @Async("threadPoolTaskExecutor")
    public void publishRequestEvent(String requestContent) {
        System.out.println("发布事件");
        RequestEvent requestEvent = new RequestEvent(applicationContext, requestContent);
        applicationContext.publishEvent(requestEvent);
    }
}
