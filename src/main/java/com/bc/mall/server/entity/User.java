package com.bc.mall.server.entity;

import com.bc.mall.server.utils.CommonUtil;

/**
 * 用户
 *
 * @author zhou
 */
public class User extends BaseEntity {
    private String id;
    private String storeId;
    private String userName;
    private String phone;
    private String avatar;
    private String password;
    /**
     * 是否有密码
     * 0: 没有 1:有
     */
    private String hasPassword;
    private String token;
    private String source;

    public User() {

    }

    public User(String responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public User(String storeId, String userName, String phone, String avatar, String password, String source) {
        this.id = CommonUtil.generateId();
        this.storeId = storeId;
        this.userName = userName;
        this.phone = phone;
        this.avatar = avatar;
        this.password = password;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(String hasPassword) {
        this.hasPassword = hasPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
