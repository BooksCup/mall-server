package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.GoodsSku;
import com.bc.mall.server.mapper.GoodsSkuMapper;
import com.bc.mall.server.service.GoodsSkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品sku
 *
 * @author zhou
 */
@Service("goodsSkuService")
public class GoodsSkuServiceImpl implements GoodsSkuService {
    @Resource
    private GoodsSkuMapper goodsSkuMapper;

    /**
     * 获取商品默认规格(用于商品详情页规格模块的加载)
     *
     * @param goodsId 商品ID
     * @return 商品默认规格
     */
    @Override
    public GoodsSku getGoodsDefSku(String goodsId) {
        return goodsSkuMapper.getGoodsDefSku(goodsId);
    }

    /**
     * 根据商品ID获取商品sku列表
     *
     * @param paramMap 参数map
     * @return 商品sku列表
     */
    @Override
    public List<GoodsSku> getGoodsSkuListByGoodsId(Map<String, String> paramMap) {
        return goodsSkuMapper.getGoodsSkuListByGoodsId(paramMap);
    }
}
