package com.example.demo.transfer;

import com.example.demo.entity.User;
import com.example.demo.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author kiki
 */
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);


    @Mappings({
            @Mapping(source = "name",target = "userName"),
            @Mapping(source = "age",target = "userAge")}
    )
    UserVO user2VO(User user);
}
