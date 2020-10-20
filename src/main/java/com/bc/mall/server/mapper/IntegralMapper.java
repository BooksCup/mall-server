package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.integral.IntegralConfig;

import java.util.List;

/**
 * 积分商城
 *
 * @author zhou
 */
public interface IntegralMapper {

    /**
     * 根据店铺ID查找积分商城配置列表
     *
     * @param storeId 店铺ID
     * @return 积分商城配置列表
     */
    List<IntegralConfig> getIntegralConfigListByStoreId(String storeId);
}
