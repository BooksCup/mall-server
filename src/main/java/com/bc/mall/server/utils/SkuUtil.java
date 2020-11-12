package com.bc.mall.server.utils;

import com.alibaba.fastjson.JSON;
import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.GoodsSku;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkuUtil {
    public static List<Map<String, Object>> sku2Map(List<GoodsSku> goodsSkuList) {
        List<Map<String, Object>> goodsSkuMapList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(goodsSkuList)) {
            for (GoodsSku goodsSku : goodsSkuList) {
                Map<String, Object> skuMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
                skuMap.put(Constant.SKU_KEY_ID, goodsSku.getId());
                skuMap.put(Constant.SKU_KEY_STOCK, goodsSku.getRemainStock());
                skuMap.put(Constant.SKU_KEY_PRICE, goodsSku.getSellPrice());
                skuMap.put(Constant.SKU_KEY_IMAGE, goodsSku.getImage());
                String attr = goodsSku.getAttr();
                Map<String, Object> attrMap = JSON.parseObject(attr, Map.class);
                if (null != attrMap && attrMap.size() > 0) {
                    skuMap.putAll(attrMap);
                }
                goodsSkuMapList.add(skuMap);
            }
        }
        return goodsSkuMapList;
    }

    public static void main(String[] args) {
//        List<GoodsSku> goodsSkuList = new ArrayList<>();
//        GoodsSku goodsSku = new GoodsSku();
//        goodsSku.setId("152");
//        goodsSku.setRemainStock("10631");
//        goodsSku.setSellPrice("100.00");
//        goodsSku.setAttr("{\"颜色\":\"红色\",\"尺码\":\"XXL\"}");
//        goodsSkuList.add(goodsSku);
//        List<Map<String, Object>> goodsSkuMapList = sku2Map(goodsSkuList);
//        System.out.println(goodsSkuMapList);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("颜色", "红色");
        map2.put("尺码", "XXL");
        System.out.println(JSON.toJSONString(map2));
    }
}
