package com.bc.mall.server.entity;

import com.bc.mall.server.utils.CommonUtil;

/**
 * 验证码
 *
 * @author zhou
 */
public class VerifyCode {
    private String id;
    private String phone;
    private String code;
    private Integer category;
    private String createTime;
    private String expireTime;

    public VerifyCode() {

    }

    public VerifyCode(String phone, String code, Integer category, long period) {
        this.id = CommonUtil.generateId();
        this.phone = phone;
        this.code = code;
        this.category = category;
        this.createTime = CommonUtil.now();
        this.expireTime = CommonUtil.getExpireTime(period);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }
}
