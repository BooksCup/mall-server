package com.bc.mall.server.entity;

import java.util.List;

/**
 * 首页信息
 *
 * @author zhou
 */
public class HomeProfile {

    /**
     * 轮播图
     */
    private List<Banner> bannerList;

    /**
     * 插件
     */
    private List<Plugin> pluginList;

    /**
     * 商品分类
     */
    private List<GoodsClass> goodsClassList;

    /**
     * 猜你喜欢商品
     */
    private List<Goods> likeGoodsList;

    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    public List<Plugin> getPluginList() {
        return pluginList;
    }

    public void setPluginList(List<Plugin> pluginList) {
        this.pluginList = pluginList;
    }

    public List<GoodsClass> getGoodsClassList() {
        return goodsClassList;
    }

    public void setGoodsClassList(List<GoodsClass> goodsClassList) {
        this.goodsClassList = goodsClassList;
    }

    public List<Goods> getLikeGoodsList() {
        return likeGoodsList;
    }

    public void setLikeGoodsList(List<Goods> likeGoodsList) {
        this.likeGoodsList = likeGoodsList;
    }
}
