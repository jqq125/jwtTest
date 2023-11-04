package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryUserList();

    List<UserVO> selectUser();
}
