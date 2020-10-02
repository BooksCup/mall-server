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
}
