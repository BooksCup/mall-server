package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.Banner;

import java.util.List;
import java.util.Map;

/**
 * 轮播图
 *
 * @author zhou
 */
public interface BannerMapper {

    /**
     * 获取轮播图列表
     *
     * @param paramMap 参数map
     * @return 轮播图列表
     */
    List<Banner> getBannerList(Map<String, Object> paramMap);
}
