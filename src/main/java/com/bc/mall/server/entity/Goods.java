package com.bc.mall.server.entity;

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

    /**
     * 销售价格
     */
    private String sellPrice;
    private String originalPrice;

    /**
     * 商品详情(html标签)
     */
    private String content;

    private List<GoodsAlbum> goodsAlbumList;

    /**
     * 商品评论
     */
    private List<Comment> commentList;

    /**
     * 是否被收藏
     */
    private String isCollected;

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

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<GoodsAlbum> getGoodsAlbumList() {
        return goodsAlbumList;
    }

    public void setGoodsAlbumList(List<GoodsAlbum> goodsAlbumList) {
        this.goodsAlbumList = goodsAlbumList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(String isCollected) {
        this.isCollected = isCollected;
    }
}
