package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.User;
import com.bc.mall.server.mapper.UserMapper;
import com.bc.mall.server.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    /**
     * 检查用户名是否存在
     *
     * @param paramMap 参数map
     * @return true:存在 false:不存在
     */
    @Override
    public boolean checkUserNameExist(Map<String, String> paramMap) {
        List<User> userList = userMapper.getUserListByUserName(paramMap);
        if (!CollectionUtils.isEmpty(userList)) {
            return true;
        }
        return false;
    }

    /**
     * 检查手机号是否存在
     *
     * @param paramMap 参数map
     * @return true:存在 false:不存在
     */
    @Override
    public boolean checkPhoneExist(Map<String, String> paramMap) {
        List<User> userList = userMapper.getUserListByPhone(paramMap);
        if (!CollectionUtils.isEmpty(userList)) {
            return true;
        }
        return false;
    }

    /**
     * 通过账号(用户名/手机号)获取用户列表
     *
     * @param paramMap 参数map
     * @return 用户列表
     */
    @Override
    public List<User> getUserListByAccount(Map<String, String> paramMap) {
        return userMapper.getUserListByAccount(paramMap);
    }

    /**
     * 修改用户token和最后一次登录时间
     *
     * @param user 用户
     */
    @Override
    public void updateUserByLogin(User user) {
        userMapper.updateUserByLogin(user);
    }

    /**
     * 保存用户
     *
     * @param user 用户
     */
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
