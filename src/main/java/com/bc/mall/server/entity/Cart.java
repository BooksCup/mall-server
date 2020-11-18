package com.bc.mall.server.entity;

import com.bc.mall.server.utils.CommonUtil;

/**
 * 购物车
 *
 * @author zhou
 */
public class Cart extends BaseResponse {
    private String id;
    private String storeId;
    private String goodsId;
    private String skuId;
    private String userId;
    private Integer goodsNum;
    private String createTime;

    public Cart() {

    }

    public Cart(String responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public Cart(String storeId, String goodsId, String skuId, String userId, Integer goodsNum) {
        this.id = CommonUtil.generateId();
        this.storeId = storeId;
        this.goodsId = goodsId;
        this.skuId = skuId;
        this.userId = userId;
        this.goodsNum = goodsNum;
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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
