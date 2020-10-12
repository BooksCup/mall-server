package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserListByUserName(String userName);

    List<User> getUserListByPhone(String phone);
}
