package com.bc.mall.server.entity;

/**
 * 基础entity
 *
 * @author zhou
 */
public class BaseEntity {
    private String responseCode;
    private String responseMessage;

    public BaseEntity(){

    }

    public BaseEntity(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

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
