package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.integral.IntegralConfig;
import com.bc.mall.server.mapper.IntegralMapper;
import com.bc.mall.server.service.IntegralService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 积分商城
 *
 * @author zhou
 */
@Service("integralService")
public class IntegralServiceImpl implements IntegralService {

    @Resource
    private IntegralMapper integralMapper;

    /**
     * 根据店铺ID查找积分商城配置
     *
     * @param storeId 店铺ID
     * @return 积分商城配置
     */
    @Override
    public IntegralConfig getIntegralConfigByStoreId(String storeId) {
        List<IntegralConfig> integralConfigList = integralMapper.getIntegralConfigListByStoreId(storeId);
        if (!CollectionUtils.isEmpty(integralConfigList)) {
            return integralConfigList.get(0);
        }
        return null;
    }
}
