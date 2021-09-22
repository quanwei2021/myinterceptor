package com.quanwei.myinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/hello")
    public String HelloDemo01() {
        return "hello Interceptor!!!!";
    }

    @GetMapping("/demo")
    public String Demo02(String userId) {
        return "如果不加userId,请求将被拦截测试";
    }
}
