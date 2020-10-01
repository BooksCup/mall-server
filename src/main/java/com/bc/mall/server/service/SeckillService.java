package com.bc.mall.server.service;

import com.bc.mall.server.entity.seckill.SeckillConfig;

/**
 * 秒杀
 *
 * @author zhou
 */
public interface SeckillService {

    /**
     * 根据店铺ID查找秒杀配置
     *
     * @param storeId 店铺ID
     * @return 秒杀配置
     */
    SeckillConfig getSeckillConfigByStoreId(String storeId);
}
