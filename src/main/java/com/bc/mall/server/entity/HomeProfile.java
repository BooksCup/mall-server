package com.bc.mall.server.entity;

import java.util.List;

/**
 * 首页信息
 *
 * @author zhou
 */
public class HomeProfile {

    private List<Banner> bannerList;

    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }
}
