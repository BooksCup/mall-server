package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
public interface UserMapper {
    /**
     * 根据用户名获取用户列表
     *
     * @param paramMap 参数map
     * @return 用户列表
     */
    List<User> getUserListByUserName(Map<String, Object> paramMap);

    /**
     * 根据手机号获取用户列表
     *
     * @param paramMap 参数map
     * @return 用户列表
     */
    List<User> getUserListByPhone(Map<String, Object> paramMap);

    /**
     * 通过账号(用户名/手机号)获取用户列表
     *
     * @param paramMap 参数map
     * @return 用户列表
     */
    List<User> getUserListByAccount(Map<String, String> paramMap);

    /**
     * 修改用户token和最后一次登录时间
     *
     * @param user 用户
     */
    void updateUserByLogin(User user);

    /**
     * 保存用户
     *
     * @param user 用户
     */
    void addUser(User user);
}
