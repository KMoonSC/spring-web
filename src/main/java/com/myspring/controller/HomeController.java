package com.myspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by xuyuan 18/8/18
 */
@RestController
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
