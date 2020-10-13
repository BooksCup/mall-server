package com.bc.mall.server.enums;

/**
 * 返回消息
 *
 * @author zhou
 */
public enum ResponseMsg {
    /**
     * mall-server接口返回信息
     */
    USER_NAME_EXISTS("USER_NAME_EXISTS", "该账号已存在!"),
    USER_PHONE_EXISTS("USER_PHONE_EXISTS", "该手机号码已注册,请登录!"),
    USER_NOT_REGISTER("USER_NOT_REGISTER", "该号码未注册,请注册!"),
    PASSWORD_NOT_CORRECT("PASSWORD_NOT_CORRECT", "密码错误!"),

    LOGIN_SUCCESS("LOGIN_SUCCESS", "登录成功!"),
    ;

    ResponseMsg(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    private String responseCode;
    private String responseMessage;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
