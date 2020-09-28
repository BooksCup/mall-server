package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.bargain.BargainConfig;
import com.bc.mall.server.mapper.BargainMapper;
import com.bc.mall.server.service.BargainService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 砍价
 *
 * @author zhou
 */
@Service("bargainService")
public class BargainServiceImpl implements BargainService {

    @Resource
    private BargainMapper bargainMapper;

    /**
     * 根据店铺ID查找砍价配置
     *
     * @param storeId 店铺ID
     * @return 砍价配置
     */
    @Override
    public BargainConfig getBargainConfigByStoreId(String storeId) {
        List<BargainConfig> bargainConfigList = bargainMapper.getBargainConfigListByStoreId(storeId);
        if (!CollectionUtils.isEmpty(bargainConfigList)) {
            return bargainConfigList.get(0);
        }
        return null;
    }
}
