package com.bc.mall.server.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品
 *
 * @author zhou
 */
public class Goods {

    private String id;
    private String storeId;
    private String name;
    private String shortName;
    private String image;
    private Integer salesVolume;
    private Integer status;
    private BigDecimal sellPrice;
    private BigDecimal originalPrice;

    private List<GoodsAlbum> goodsAlbumList;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public List<GoodsAlbum> getGoodsAlbumList() {
        return goodsAlbumList;
    }

    public void setGoodsAlbumList(List<GoodsAlbum> goodsAlbumList) {
        this.goodsAlbumList = goodsAlbumList;
    }
}
