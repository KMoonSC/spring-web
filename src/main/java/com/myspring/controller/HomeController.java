package com.myspring.controller;

import com.alibaba.fastjson.JSON;
import com.myspring.repo.UserAdminRepo;
import com.myspring.repo.UserAdminRepoImpl;
import com.myspring.repo.UserAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by xuyuan 18/8/18
 */
@RestController
public class HomeController {

    @Autowired
    private UserAdminRepo userAdminRepo;

    @Autowired
    private UserAdminRepository userAdminRepository;

    @GetMapping("/home")
    public String home() {
        return "home_data";
    }

    @GetMapping("/login")
    public String login() {
        // 这里登录放回的token是每次身份验证的票据
        return "token_123";
    }

    @GetMapping("/account")
    public String account() {
        return JSON.toJSONString(userAdminRepo.findOne(207));
    }

    @GetMapping("/account_by_jpa")
    public String accountByJpa() {
        return JSON.toJSONString(userAdminRepository.findById(207));
    }
}
