package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.Cart;
import com.bc.mall.server.entity.Goods;
import com.bc.mall.server.mapper.CartMapper;
import com.bc.mall.server.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    /**
     * 根据用户信息和商品信息查询购物车中的商品
     *
     * @param paramMap 参数map(包含用户ID,商品ID,商品规格ID)
     * @return 购物车中的商品
     */
    @Override
    public Cart getCartByUserAndGoods(Map<String, Object> paramMap) {
        List<Cart> cartList = cartMapper.getCartListByUserAndGoods(paramMap);
        if (!CollectionUtils.isEmpty(cartList)) {
            return cartList.get(0);
        }
        return null;
    }

    /**
     * 更新购物车中商品数量
     *
     * @param paramMap 参数map
     */
    @Override
    public void updateCartGoodsNum(Map<String, Object> paramMap) {
        cartMapper.updateCartGoodsNum(paramMap);
    }

    /**
     * 获取购物车中的商品列表
     *
     * @param paramMap 参数map
     * @return 购物车中的商品列表
     */
    @Override
    public List<Goods> getCartGoods(Map<String, Object> paramMap) {
        return cartMapper.getCartGoods(paramMap);
    }
}
