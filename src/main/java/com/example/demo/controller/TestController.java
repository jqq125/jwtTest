package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.transfer.UserConvert;
import com.example.demo.vo.UserVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ApiOperationSupport(order = 2)
    public String modify(@RequestBody User user) {
        UserVO userVO = UserConvert.INSTANCE.user2VO(user);
        return userVO.toString();
    }

    @Autowired
    private UserService userService;

    @GetMapping("/queryUser")
    @ApiOperationSupport(order = 3)
    public List<User> queryUser() {
        List<User> users = userService.queryUserList();
        return users;
    }

}
