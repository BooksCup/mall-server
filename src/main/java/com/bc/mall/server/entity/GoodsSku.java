package com.bc.mall.server.entity;

/**
 * 商品规格
 *
 * @author zhou
 */
public class GoodsSku {
    /**
     * 销售价格
     */
    private String sellPrice;

    /**
     * 最低销售价格
     */
    private String minSellPrice;

    /**
     * 最高销售价格
     */
    private String maxSellPrice;

    private String originalPrice;
    private String minOriginalPrice;
    private String maxOriginalPrice;

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getMinSellPrice() {
        return minSellPrice;
    }

    public void setMinSellPrice(String minSellPrice) {
        this.minSellPrice = minSellPrice;
    }

    public String getMaxSellPrice() {
        return maxSellPrice;
    }

    public void setMaxSellPrice(String maxSellPrice) {
        this.maxSellPrice = maxSellPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getMinOriginalPrice() {
        return minOriginalPrice;
    }

    public void setMinOriginalPrice(String minOriginalPrice) {
        this.minOriginalPrice = minOriginalPrice;
    }

    public String getMaxOriginalPrice() {
        return maxOriginalPrice;
    }

    public void setMaxOriginalPrice(String maxOriginalPrice) {
        this.maxOriginalPrice = maxOriginalPrice;
    }
}
