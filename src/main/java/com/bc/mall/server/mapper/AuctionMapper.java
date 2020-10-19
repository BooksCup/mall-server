package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.auction.AuctionConfig;

import java.util.List;

/**
 * 竞拍
 *
 * @author zhou
 */
public interface AuctionMapper {

    /**
     * 根据店铺ID查找竞拍配置列表
     *
     * @param storeId 店铺ID
     * @return 竞拍配置列表
     */
    List<AuctionConfig> getAuctionConfigListByStoreId(String storeId);
}
