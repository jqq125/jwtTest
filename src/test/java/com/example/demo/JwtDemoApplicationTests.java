package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class JwtDemoApplicationTests {

    @Test
    void contextLoads() throws Exception {
        String token = Token.createToken(1350000L);
        System.out.println(token);

        Long appUID = Token.getAppUID(token);
        System.out.println(appUID);

    }

    @Autowired
    DataSource dataSource;
    @Test
    void testJDBC() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
