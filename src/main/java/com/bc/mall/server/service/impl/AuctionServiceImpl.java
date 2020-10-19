package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.auction.AuctionConfig;
import com.bc.mall.server.mapper.AuctionMapper;
import com.bc.mall.server.service.AuctionService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 竞拍
 *
 * @author zhou
 */
@Service("auctionService")
public class AuctionServiceImpl implements AuctionService {

    @Resource
    private AuctionMapper auctionMapper;

    /**
     * 根据店铺ID查找竞拍配置
     *
     * @param storeId 店铺ID
     * @return 竞拍配置
     */
    @Override
    public AuctionConfig getAuctionConfigByStoreId(String storeId) {
        List<AuctionConfig> auctionConfigList = auctionMapper.getAuctionConfigListByStoreId(storeId);
        if (!CollectionUtils.isEmpty(auctionConfigList)) {
            return auctionConfigList.get(0);
        }
        return null;
    }
}
