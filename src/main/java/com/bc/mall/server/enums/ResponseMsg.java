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
    STORE_CONFIG_EMPTY("STORE_CONFIG_ERROR", "请商城管理员填写基础配置!"),
    STORE_CONFIG_NOT_CORRECT("STORE_CONFIG_NOT_CORRECT", "授权配置错误!"),
    BIND_WECHAT_USER_SUCCESS("BIND_WECHAT_USER_SUCCESS", "微信用户绑定成功!"),

    OPEN_ID_EMPTY("OPEN_ID_EMPTY", "微信openid异常!"),

    USER_NAME_EXISTS("USER_NAME_EXISTS", "该账号已存在!"),
    USER_PHONE_EXISTS("USER_PHONE_EXISTS", "该手机号码已注册,请登录!"),
    USER_NOT_REGISTER("USER_NOT_REGISTER", "该号码未注册,请注册!"),
    PASSWORD_NOT_CORRECT("PASSWORD_NOT_CORRECT", "密码错误!"),
    VERIFY_CODE_NOT_CORRECT("VERIFY_CODE_NOT_CORRECT", "验证码错误!"),

    LOGIN_SUCCESS("LOGIN_SUCCESS", "登录成功!"),
    SERVER_ERROR("SERVER_ERROR", "网络繁忙!"),
    PARAM_ILLEGAL("PARAM_ILLEGAL", "参数错误!"),
    NOT_LOGIN("NOT_LOGIN", "请登录!"),
    ADD_TO_CART_SUCCESS("ADD_TO_CART_SUCCESS", "加入购物车成功!"),
    BUY_NOW_SUCCESS("BUY_NOW_SUCCESS", "立即购买成功!"),

    GET_VERIFY_CODE_SUCCESS("GET_VERIFY_CODE_SUCCESS", "获取验证码成功"),
    GET_VERIFY_CODE_ERROR("GET_VERIFY_CODE_ERROR", "获取验证码失败"),

    CHECK_TOKEN_SUCCESS("CHECK_TOKEN_SUCCESS", "检查token成功"),

    GOODS_OFF_SHELVE("GOODS_OFF_SHELVE", "该商品已下架!"),
    STOCK_NOT_ENOUGH("STOCK_NOT_ENOUGH", "库存不足"),

    COLLECTION_EXISTS("COLLECTION_EXISTS", "已经收藏!"),
    CANCEL_COLLECT_SUCCESS("CANCEL_COLLECT_SUCCESS", "取消收藏成功!"),
    COLLECT_SUCCESS("COLLECT_SUCCESS", "收藏成功!"),

    UPDATE_CART_GOODS_NUM_SUCCESS("UPDATE_CART_GOODS_NUM_SUCCESS", "修改购物车中商品数量成功!"),
    UPDATE_CART_GOODS_NUM_ERROR("UPDATE_CART_GOODS_NUM_ERROR", "修改购物车中商品数量失败!"),
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
