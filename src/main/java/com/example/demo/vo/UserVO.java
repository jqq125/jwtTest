package com.example.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kiki
 */
@Data
public class UserVO {

    @ApiModelProperty("姓名")
    private String userName;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("年龄")
    private Integer userAge;



}
