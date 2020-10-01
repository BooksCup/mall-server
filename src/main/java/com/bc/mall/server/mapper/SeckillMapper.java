package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.seckill.SeckillConfig;

import java.util.List;

/**
 * 秒杀
 *
 * @author zhou
 */
public interface SeckillMapper {

    /**
     * 根据店铺ID查找秒杀配置列表
     *
     * @param storeId 店铺ID
     * @return 秒杀配置列表
     */
    List<SeckillConfig> getSeckillConfigListByStoreId(String storeId);
}
