package com.bc.mall.server.entity;

import com.bc.mall.server.utils.CommonUtil;

/**
 * 用户收藏
 *
 * @author zhou
 */
public class UserCollection extends BaseResponse {
    private String id;
    private String storeId;
    private String userId;
    private String type;
    private String shopId;
    private String goodsId;
    private String createTime;

    public UserCollection() {

    }

    public UserCollection(String responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public UserCollection(String storeId, String userId, String type,
                          String shopId, String goodsId) {
        this.id = CommonUtil.generateId();
        this.storeId = storeId;
        this.userId = userId;
        this.type = type;
        this.shopId = shopId;
        this.goodsId = goodsId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
