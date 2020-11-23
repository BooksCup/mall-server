package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.EntityStore;
import com.bc.mall.server.entity.Shop;
import com.bc.mall.server.mapper.ShopMapper;
import com.bc.mall.server.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 店铺
 *
 * @author zhou
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopMapper shopMapper;

    /**
     * 根据店铺ID查询店铺
     *
     * @param paramMap 参数map
     * @return 店铺
     */
    @Override
    public Shop getShopByShopId(Map<String, Object> paramMap) {
        List<Shop> shopList = shopMapper.getShopListByShopId(paramMap);
        if (!CollectionUtils.isEmpty(shopList)) {
            return shopList.get(0);
        }
        return null;
    }

    /**
     * 根据店铺ID列表查询店铺列表
     *
     * @param paramMap 参数map
     * @return 店铺列表
     */
    @Override
    public List<Shop> getShopListByShopIdList(Map<String, Object> paramMap) {
        return shopMapper.getShopListByShopIdList(paramMap);
    }

    /**
     * 获取店铺在售商品数量
     *
     * @param shopId 店铺ID
     * @return 在售商品数量
     */
    @Override
    public Integer getShopOnSaleGoodsNum(String shopId) {
        return shopMapper.getShopOnSaleGoodsNum(shopId);
    }

    /**
     * 获取店铺总销量
     *
     * @param shopId 店铺ID
     * @return 总销量
     */
    @Override
    public Integer getShopTotalSalesVolume(String shopId) {
        return shopMapper.getShopTotalSalesVolume(shopId);
    }

    /**
     * 根据店铺ID获取线下门店列表
     *
     * @param paramMap 参数map
     * @return 线下门店列表
     */
    @Override
    public List<EntityStore> getEntityStoreListByShopId(Map<String, Object> paramMap) {
        return shopMapper.getEntityStoreListByShopId(paramMap);
    }
}
