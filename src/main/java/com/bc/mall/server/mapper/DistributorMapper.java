package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.distributor.DistributorConfig;

import java.util.List;

/**
 * 分销
 *
 * @author zhou
 */
public interface DistributorMapper {

    /**
     * 根据店铺ID查找分销配置列表
     *
     * @param storeId 店铺ID
     * @return 分销配置列表
     */
    List<DistributorConfig> getDistributorConfigListByStoreId(String storeId);
}
