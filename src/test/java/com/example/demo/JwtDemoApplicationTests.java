package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class JwtDemoApplicationTests {

    @Test
    void contextLoads() throws Exception {
        String token = Token.createToken(1350000L);
        System.out.println(token);

        Long appUID = Token.getAppUID(token);
        System.out.println(appUID);

    }

}
