package com.bc.mall.server.entity;

/**
 * 商品规格
 *
 * @author zhou
 */
public class GoodsSku {
    private String id;
    private String goodsId;

    /**
     * 成本价
     */
    private String costPrice;

    /**
     * 出售价
     */
    private String sellPrice;

    /**
     * 原价格
     */
    private String origPrice;

    private String image;

    private String totalStock;
    private Integer remainStock;
    private String unit;
    private String attr;

    /**
     * 最低销售价格
     */
    private String minSellPrice;

    /**
     * 最高销售价格
     */
    private String maxSellPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getOrigPrice() {
        return origPrice;
    }

    public void setOrigPrice(String origPrice) {
        this.origPrice = origPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(String totalStock) {
        this.totalStock = totalStock;
    }

    public Integer getRemainStock() {
        return remainStock;
    }

    public void setRemainStock(Integer remainStock) {
        this.remainStock = remainStock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
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
}
