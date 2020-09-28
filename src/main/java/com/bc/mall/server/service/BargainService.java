package com.bc.mall.server.service;

import com.bc.mall.server.entity.bargain.BargainConfig;

/**
 * 砍价
 *
 * @author zhou
 */
public interface BargainService {
    /**
     * 根据店铺ID查找砍价配置
     *
     * @param storeId 店铺ID
     * @return 砍价配置
     */
    BargainConfig getBargainConfigByStoreId(String storeId);
}
