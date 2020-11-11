package com.bc.mall.server.service;

import com.bc.mall.server.entity.User;

import java.util.List;
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
    boolean checkUserNameExist(Map<String, Object> paramMap);

    /**
     * 检查手机号是否存在
     *
     * @param paramMap 参数map
     * @return true:存在 false:不存在
     */
    boolean checkPhoneExist(Map<String, Object> paramMap);

    /**
     * 根据token获取用户列表
     *
     * @param paramMap 参数map
     * @return 用户列表
     */
    List<User> getUserListByToken(Map<String, String> paramMap);

    /**
     * 根据openid获取用户
     *
     * @param paramMap 参数map
     * @return 用户
     */
    User getUserByOpenId(Map<String, String> paramMap);

    /**
     * 通过账号(用户名/手机号)获取用户列表
     *
     * @param paramMap 参数map
     * @return 用户列表
     */
    List<User> getUserListByAccount(Map<String, String> paramMap);

    /**
     * 根据手机号获取用户列表
     *
     * @param paramMap 参数map
     * @return 用户列表
     */
    List<User> getUserListByPhone(Map<String, Object> paramMap);

    /**
     * 修改用户token和最后一次登录时间
     *
     * @param user 用户
     */
    void updateUserByLogin(User user);

    /**
     * 修改用户token
     *
     * @param user 用户
     */
    void updateUserToken(User user);

    /**
     * 保存用户
     *
     * @param user 用户
     */
    void addUser(User user);

    /**
     * 微信授权时保存用户
     *
     * @param user 用户
     */
    void addUserByWechatAuth(User user);

    /**
     * 微信授权时修改用户
     *
     * @param user 用户
     */
    void updateUserByWechatAuth(User user);

    /**
     * 检查用户是否收藏某件商品
     *
     * @param paramMap 参数map
     * @return true: 已收藏 false: 未收藏
     */
    boolean checkUserGoodsCollectionExists(Map<String, String> paramMap);
}
