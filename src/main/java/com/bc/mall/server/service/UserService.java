package com.bc.mall.server.service;

import com.bc.mall.server.entity.User;

import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
public interface UserService {
    /**
     * 检查用户名是否存在
     *
     * @param paramMap 参数map
     * @return true:存在 false:不存在
     */
    boolean checkUserNameExist(Map<String, String> paramMap);

    /**
     * 检查手机号是否存在
     *
     * @param paramMap 参数map
     * @return true:存在 false:不存在
     */
    boolean checkPhoneExist(Map<String, String> paramMap);

    /**
     * 保存用户
     *
     * @param user 用户
     */
    void addUser(User user);
}
