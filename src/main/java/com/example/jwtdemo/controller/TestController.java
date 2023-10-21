package com.example.jwtdemo.controller;

import com.example.jwtdemo.entity.User;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSort;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * {@code @author:kiki}
 */
@RestController
@Api(tags = "应用测试")
@RequestMapping("/test")
@ApiSupport(order = 1)
public class TestController {
    @PostMapping("/hello")
    @ApiOperationSupport(order = 1)
    public String hello(@RequestBody User user){
        return "hello"+user;
    }

    @PostMapping("/modify")
    @ApiOperationSupport(order = 2, ignoreParameters ="age")
    public String modify(User user){
        return "hello"+user;
    }

}
