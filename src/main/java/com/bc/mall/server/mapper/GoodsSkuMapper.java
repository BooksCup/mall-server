package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.GoodsSku;

import java.util.List;
import java.util.Map;

/**
 * 商品sku
 *
 * @author zhou
 */
public interface GoodsSkuMapper {

    /**
     * 获取商品默认规格(用于商品详情页规格模块的加载)
     *
     * @param goodsId 商品ID
     * @return 商品默认规格
     */
    GoodsSku getGoodsDefSku(String goodsId);

    /**
     * 根据商品ID获取商品sku列表
     *
     * @param paramMap 参数map
     * @return 商品sku列表
     */
    List<GoodsSku> getGoodsSkuListByGoodsId(Map<String, String> paramMap);

    /**
     * 根据skuId获取商品sku
     *
     * @param skuId skuId
     * @return 商品sku
     */
    GoodsSku getGoodsSkuBySkuId(String skuId);
}
