package com.bc.mall.server.service;

/**
 * 用户
 * @author zhou
 */
public interface UserService {
    boolean checkUserNameExist(String userName);
    boolean checkPhoneExist(String phone);
}
