package com.bc.mall.server.service;

import com.bc.mall.server.entity.distributor.DistributorConfig;

/**
 * 分销
 *
 * @author zhou
 */
public interface DistributorService {
    /**
     * 根据店铺ID查找分销配置
     *
     * @param storeId 店铺ID
     * @return 分销配置
     */
    DistributorConfig getDistributorConfigByStoreId(String storeId);
}
