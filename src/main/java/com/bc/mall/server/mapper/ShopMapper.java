package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.EntityStore;
import com.bc.mall.server.entity.Shop;

import java.util.List;
import java.util.Map;

/**
 * 店铺
 *
 * @author zhou
 */
public interface ShopMapper {

    /**
     * 根据店铺ID查询店铺
     *
     * @param paramMap 参数map
     * @return 店铺
     */
    List<Shop> getShopListByShopId(Map<String, String> paramMap);

    /**
     * 获取店铺在售商品数量
     *
     * @param shopId 店铺ID
     * @return 在售商品数量
     */
    Integer getShopOnSaleGoodsNum(String shopId);

    /**
     * 获取店铺总销量
     *
     * @param shopId 店铺ID
     * @return 总销量
     */
    Integer getShopTotalSalesVolume(String shopId);

    /**
     * 根据店铺ID获取线下门店列表
     *
     * @param paramMap 参数map
     * @return 线下门店列表
     */
    List<EntityStore> getEntityStoreListByShopId(Map<String, String> paramMap);
}
