package com.bc.mall.server.service;

import com.bc.mall.server.entity.GoodsSku;

import java.util.List;
import java.util.Map;

public interface GoodsSkuService {

    List<GoodsSku> getGoodsSkuListByGoodsId(Map<String, String> paramMap);
}
