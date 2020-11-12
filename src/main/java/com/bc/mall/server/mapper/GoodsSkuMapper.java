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
    List<GoodsSku> getGoodsSkuListByGoodsId(Map<String, String> paramMap);
}
