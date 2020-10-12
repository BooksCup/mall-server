package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.User;
import com.bc.mall.server.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户
 *
 * @author zhou
 */
@Service("userService")
public class UserServiceImpl {
    @Resource
    UserMapper userMapper;

    public boolean checkUserNameExist(String userName) {
        List<User> userList = userMapper.getUserListByUserName(userName);
        if (!CollectionUtils.isEmpty(userList)) {
            return true;
        }
        return false;
    }

    public boolean checkPhoneExist(String phone) {
        List<User> userList = userMapper.getUserListByPhone(phone);
        if (!CollectionUtils.isEmpty(userList)) {
            return true;
        }
        return false;
    }
}
