package com.bc.mall.server.service;

import com.bc.mall.server.entity.integral.IntegralConfig;

/**
 * 积分商城
 *
 * @author zhou
 */
public interface IntegralService {

    /**
     * 根据店铺ID查找积分商城配置
     *
     * @param storeId 店铺ID
     * @return 积分商城配置
     */
    IntegralConfig getIntegralConfigByStoreId(String storeId);
}
