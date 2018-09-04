package com.myspring.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 事件
 * created by xuyuan 18/9/4
 */
@Data
public class RequestEvent extends ApplicationEvent {

    private String requestContent;

    public RequestEvent(Object source, String requestContent) {
        super(source);
        this.requestContent = requestContent;
    }
}
