package com.bc.mall.server.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.bc.mall.server.service.TokenService;
import com.bc.mall.server.utils.Md5Util;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token
 *
 * @author zhou
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {

    /**
     * 过期时间2小时
     */
    private static final long EXPIRE_TIME = 2 * 60 * 60 * 1000;

    /**
     * 使用HMAC生成信息摘要时所使用的密钥
     */
    private static final String secret = "www.hirra.com";

    /**
     * 生成token
     *
     * @return token
     */
    @Override
    public String getToken() {
        // 头部信息
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        Algorithm algorithm = Algorithm.HMAC256(secret);

        Date now = new Date();
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        String token = JWT.create().withHeader(header)
                /**
                 * 设置载荷payload:存放有效信息的地方
                 */
                .withClaim("iat", now)
                .withClaim("exp", expireDate)
                .withClaim("jti", Md5Util.encode(String.valueOf(System.currentTimeMillis()), "utf8"))
                .withIssuedAt(now)
                .withExpiresAt(expireDate)
                .sign(algorithm);
        return token;
    }

    /**
     * 验证token
     *
     * @param token token
     * @return true: 验证成功  false: 验证失败
     */
    @Override
    public boolean verifyToken(String token) {
        boolean verifyResult;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            verifyResult = true;
        } catch (Exception e) {
            e.printStackTrace();
            verifyResult = false;
        }
        return verifyResult;
    }
}
