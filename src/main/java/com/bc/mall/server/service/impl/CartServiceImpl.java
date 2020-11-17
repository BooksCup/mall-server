package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.Cart;
import com.bc.mall.server.mapper.CartMapper;
import com.bc.mall.server.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 购物车
 *
 * @author zhou
 */
@Service("cartService")
public class CartServiceImpl implements CartService {

    @Resource
    private CartMapper cartMapper;

    /**
     * 保存购物车
     *
     * @param cart 购物车
     */
    @Override
    public void saveCart(Cart cart) {
        cartMapper.saveCart(cart);
    }

}
