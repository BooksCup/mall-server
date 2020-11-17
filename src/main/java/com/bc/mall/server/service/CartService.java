package com.bc.mall.server.service;

import com.bc.mall.server.entity.Cart;

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
}
