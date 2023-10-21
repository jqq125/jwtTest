package com.example.jwtdemo;

import java.util.*;

import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class Token {
    /**
     * APP登录Token的生成和解析
     *
     */

    /** token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj */
    public static final String SECRET = "JKKLJOoasdlfj";
    /** token 过期时间: 10天 */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 10;

    /**
     * JWT生成Token.<br/>
     *
     * JWT构成: header, payload, signature
     *
     * @param user_id
     *            登录成功后用户user_id, 参数user_id不可传空
     */
    public static String createToken(Long user_id) throws Exception {
        // header:Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        //Payload:Claims
        //iat:签发时间
        Date iatDate = new Date();

        Calendar nowTime = Calendar.getInstance();
        //notBefore:生效时间
        nowTime.add(Calendar.MILLISECOND, 1);
        Date notBefore = nowTime.getTime();

        //exp:过期时间
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        // build token
        String token = JWT.create().withHeader(map) // header
                .withIssuer("service") //payload-Issuer
                .withExpiresAt(expiresDate) // expire time
                .withSubject("testJWT") //subject
                .withAudience("kiki","Lili") //audience
                .withNotBefore(notBefore) //not before
                .withIssuedAt(iatDate) // sign time
                .withJWTId("1234567") // JWT id
                .withClaim("user_id", null == user_id ? null : user_id.toString()) // payload-selfDefine
                .withClaim("user_name","kiki")
                .sign(Algorithm.HMAC256(SECRET)); // signature
        return token;
    }

    /**
     * 解密Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static DecodedJWT verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
             e.printStackTrace();
            // token 校验失败, 抛出Token验证非法异常
        }
        return jwt;
    }

    /**
     * 根据Token获取user_id
     *
     * @param token
     * @return user_id
     */
    public static Long getAppUID(String token) {
        DecodedJWT decodedJWT = verifyToken(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        String userId = claims.get("user_id").asString();
        if (null == userId || StringUtils.isEmpty(userId)) {
            throw new RuntimeException();
            // token 校验失败, 抛出Token验证非法异常
        }
        return Long.valueOf(Objects.requireNonNull(userId));
    }
}
