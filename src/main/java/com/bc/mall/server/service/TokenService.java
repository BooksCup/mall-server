package com.bc.mall.server.service;

/**
 * token
 *
 * @author zhou
 */
public interface TokenService {
    /**
     * 生成token
     *
     * @return token
     */
    String getToken();

    /**
     * 验证token
     *
     * @param token token
     * @return true: 验证成功  false: 验证失败
     */
    boolean verifyToken(String token);
}
