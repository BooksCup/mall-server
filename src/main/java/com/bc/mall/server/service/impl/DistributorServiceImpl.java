package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.distributor.DistributorConfig;
import com.bc.mall.server.mapper.DistributorMapper;
import com.bc.mall.server.service.DistributorService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分销
 *
 * @author zhou
 */
@Service("distributorService")
public class DistributorServiceImpl implements DistributorService {
    @Resource
    private DistributorMapper distributorMapper;

    /**
     * 根据店铺ID查找分销配置
     *
     * @param storeId 店铺ID
     * @return 分销配置
     */
    @Override
    public DistributorConfig getDistributorConfigByStoreId(String storeId) {
        List<DistributorConfig> distributorConfigList = distributorMapper.getDistributorConfigListByStoreId(storeId);
        if (!CollectionUtils.isEmpty(distributorConfigList)) {
            return distributorConfigList.get(0);
        }
        return null;
    }
}
