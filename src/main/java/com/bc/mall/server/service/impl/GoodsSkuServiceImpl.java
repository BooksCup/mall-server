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

    @Override
    public List<GoodsSku> getGoodsSkuListByGoodsId(Map<String, String> paramMap) {
        return goodsSkuMapper.getGoodsSkuListByGoodsId(paramMap);
    }
}
