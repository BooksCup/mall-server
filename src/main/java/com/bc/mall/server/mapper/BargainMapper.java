package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.bargain.BargainConfig;

import java.util.List;

/**
 * 砍价
 *
 * @author zhou
 */
public interface BargainMapper {

    /**
     * 根据店铺ID查找砍价配置列表
     *
     * @param storeId 店铺ID
     * @return 砍价配置列表
     */
    List<BargainConfig> getBargainConfigListByStoreId(String storeId);
}
