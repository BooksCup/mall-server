package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author zhou
 */
public interface GoodsMapper {

    /**
     * 通过商品类别获取商品列表
     *
     * @param paramMap 参数map
     * @return 商品列表
     */
    List<Goods> getGoodsListByGoodsClass(Map<String, String> paramMap);

    /**
     * 获取猜你喜欢商品列表
     *
     * @param paramMap 参数map
     * @return 猜你喜欢商品列表
     */
    List<Goods> getLikeGoodsList(Map<String, String> paramMap);

    /**
     * 通过商品ID获取商品列表
     *
     * @param paramMap 参数map
     * @return 商品列表
     */
    List<Goods> getGoodsListByGoodsId(Map<String, String> paramMap);
}