package com.myspring.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * created by xuyuan 18/8/18
 */

public class HomeControllerTest {

    @Test
    public void testHome() throws Exception {
        HomeController controller = new HomeController();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/home")).andReturn();
    }
}
