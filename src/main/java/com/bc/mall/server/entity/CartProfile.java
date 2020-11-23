package com.bc.mall.server.entity;

import java.util.List;

/**
 * 购物车信息
 *
 * @author zhou
 */
public class CartProfile extends BaseResponse {

    private List<Goods> goodsList;

    private List<Shop> shopList;

    public CartProfile() {

    }

    public CartProfile(String responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
