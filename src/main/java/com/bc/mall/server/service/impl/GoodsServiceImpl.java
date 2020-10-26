package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.Goods;
import com.bc.mall.server.mapper.GoodsMapper;
import com.bc.mall.server.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author zhou
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 通过商品类别获取商品列表
     *
     * @param paramMap 参数map
     * @return 商品列表
     */
    @Override
    public List<Goods> getGoodsListByGoodsClass(Map<String, String> paramMap) {
        return goodsMapper.getGoodsListByGoodsClass(paramMap);
    }

    /**
     * 获取猜你喜欢商品列表
     *
     * @param paramMap 参数map
     * @return 猜你喜欢商品列表
     */
    @Override
    public List<Goods> getLikeGoodsList(Map<String, String> paramMap) {
        return goodsMapper.getLikeGoodsList(paramMap);
    }
}
