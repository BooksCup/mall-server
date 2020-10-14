package com.bc.mall.server.entity;

/**
 * 短信模板参数
 *
 * @author zhou
 */
public class TemplateParam {
    /**
     * 验证码
     */
    private String code;

    /**
     * 订单号
     */
    private String orderNo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
