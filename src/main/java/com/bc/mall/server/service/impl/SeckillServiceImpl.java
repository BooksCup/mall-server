package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.seckill.SeckillConfig;
import com.bc.mall.server.mapper.SeckillMapper;
import com.bc.mall.server.service.SeckillService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 秒杀
 *
 * @author zhou
 */
@Service("seckillService")
public class SeckillServiceImpl implements SeckillService {

    @Resource
    private SeckillMapper seckillMapper;

    /**
     * 根据店铺ID查找秒杀配置
     *
     * @param storeId 店铺ID
     * @return 秒杀配置
     */
    @Override
    public SeckillConfig getSeckillConfigByStoreId(String storeId) {
        List<SeckillConfig> seckillConfigList = seckillMapper.getSeckillConfigListByStoreId(storeId);
        if (!CollectionUtils.isEmpty(seckillConfigList)) {
            return seckillConfigList.get(0);
        }
        return null;
    }
}
