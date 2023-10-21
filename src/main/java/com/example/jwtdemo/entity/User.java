package com.example.jwtdemo.entity;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author jiaoqq
 */
@Data
public class User {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("年龄")
    private Integer age;

}
