package com.bc.mall.server.service;

import com.bc.mall.server.entity.Cart;
import com.bc.mall.server.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * 购物车
 *
 * @author zhou
 */
public interface CartService {

    /**
     * 保存购物车
     *
     * @param cart 购物车
     */
    void saveCart(Cart cart);

    /**
     * 根据用户信息和商品信息查询购物车中的商品
     *
     * @param paramMap 参数map(包含用户ID,商品ID,商品规格ID)
     * @return 购物车中的商品
     */
    Cart getCartByUserAndGoods(Map<String, Object> paramMap);

    /**
     * 更新购物车中商品数量
     *
     * @param paramMap 参数map
     */
    void updateCartGoodsNum(Map<String, Object> paramMap);

    /**
     * 获取购物车中的商品列表
     *
     * @param paramMap 参数map
     * @return 购物车中的商品列表
     */
    List<Goods> getCartGoods(Map<String, Object> paramMap);
}
