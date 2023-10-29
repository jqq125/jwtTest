package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kiki
 */
@RestController
public class LoginController {
    @PostMapping("login")
    @ApiOperation("登录")
    public Map<String, Object> login() {
        Map<String, Object> result = new HashMap<>(2);
        result.put("success", true);
        result.put("token", "1364564646");
        return result;
    }

}
