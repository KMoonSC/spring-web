package com.myspring.service.impl;

import com.myspring.service.RestTestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * created by xuyuan 18/9/1
 */
@Service
public class RestTestServiceImpl implements RestTestService {

    @Value("${serve.url}")
    private String serveUrl;

    @Override
    public String getServe() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(serveUrl + "get_serve", String.class);
    }
}
