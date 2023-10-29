package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author kiki
 * {@code @data} 2023/10/21
 * {@code @description}
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())  //创建接口文档具体信息
                .select() //创建选择器，控制哪些接口被加入文档
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any())
                .build();

    }

    //创建接口文档的具体信息，会显示在接口文档页面中
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API接口文档")
                .description("文档描述了接口定义") //文档描述
                .contact(new Contact("kiki", "", "xxxxxxxx@qq.com")) //联系人信息
                .version("v1.0.0") //版本信息
                .license("example") //版权
                .licenseUrl("http://www.example.com") //版权地址
                .build();
    }
}
