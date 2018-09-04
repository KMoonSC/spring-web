package com.myspring.event.listener;

import com.myspring.event.RequestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 * created by xuyuan 18/9/4
 */
@Component
public class RequestListener
        //implements ApplicationListener<RequestEvent> // 用EventListener注解就不需要实现它了
{

    /**
     * 处理事件
     * @param requestEvent
     */
    //@Async("threadPoolTaskExecutor")// 放这里不生效，因为加载先后顺序注解被覆盖了
    //@Override
    @EventListener
    public void onApplicationEvent(RequestEvent requestEvent) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String requestContent = requestEvent.getRequestContent();
        System.out.println("监听到事件，内容为：" + requestContent);
    }
}
