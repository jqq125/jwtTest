package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.transfer.UserConvert;
import com.example.demo.vo.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    private UserMapper userMapper;

    @GetMapping("/queryUser")
    @ApiOperationSupport(order = 3)
    public List<User> queryUser() {
        List<User> users = userMapper.queryUserList();
        return users;
    }


    @GetMapping("/testPage")
    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "分页", tags = "分页测试")
    public List<User> testPage(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.queryUserList();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo.getList();
    }




}
