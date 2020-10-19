package com.bc.mall.server.service;

import com.bc.mall.server.entity.auction.AuctionConfig;

/**
 * 竞拍
 *
 * @author zhou
 */
public interface AuctionService {
    /**
     * 根据店铺ID查找竞拍配置
     *
     * @param storeId 店铺ID
     * @return 竞拍配置
     */
    AuctionConfig getAuctionConfigByStoreId(String storeId);
}
