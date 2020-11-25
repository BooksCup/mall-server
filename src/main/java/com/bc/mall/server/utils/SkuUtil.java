package com.bc.mall.server.utils;

import com.alibaba.fastjson.JSON;
import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.Attr;
import com.bc.mall.server.entity.GoodsSku;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * sku工具类
 *
 * @author zhou
 */
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

    public static List<Attr> sku2AttrList(List<GoodsSku> goodsSkuList) {
        Map<String, List<String>> map = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);

        if (!CollectionUtils.isEmpty(goodsSkuList)) {
            for (GoodsSku goodsSku : goodsSkuList) {
                Map<String, Object> attrMap = JSON.parseObject(goodsSku.getAttr(), Map.class);
                for (Map.Entry<String, Object> entry : attrMap.entrySet()) {
                    if (map.containsKey(entry.getKey())) {
                        List<String> attrValueList = map.get(entry.getKey());
                        if (!attrValueList.contains(entry.getValue())) {
                            attrValueList.add(String.valueOf(entry.getValue()));
                        }
                        map.put(entry.getKey(), attrValueList);
                    } else {
                        List<String> attrValueList = new ArrayList<>();
                        attrValueList.add(String.valueOf(entry.getValue()));
                        map.put(entry.getKey(), attrValueList);
                    }
                }
            }
        }
        List<Attr> attrList = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String attrId = Md5Util.encode(entry.getKey(), "utf8");
            Attr attr = new Attr();
            attr.setId(attrId);
            attr.setAttrType("1");
            attr.setAttrName(entry.getKey());
            List<Attr> subAttrList = new ArrayList<>();
            List<String> allList = entry.getValue();
            for (String attrValue : allList) {
                Attr subAttr = new Attr();
                subAttr.setId(Md5Util.encode(attrValue, "utf8"));
                subAttr.setAttributeId(attrId);
                subAttr.setAttributeValue(attrValue);
                subAttrList.add(subAttr);
            }
            attr.setAttr(subAttrList);
            attr.setAll(allList);
            attrList.add(attr);
        }

        return attrList;
    }

    public static String getSkuNameV1(String attr) {
        if (StringUtils.isEmpty(attr)) {
            return "";
        }
        StringBuffer skuNameBuffer = new StringBuffer();
        Map<String, Object> attrMap = JSON.parseObject(attr, Map.class);
        for (Map.Entry<String, Object> entry : attrMap.entrySet()) {
            skuNameBuffer.append(entry.getValue()).append(",");
        }
        if (skuNameBuffer.length() > 0) {
            skuNameBuffer.deleteCharAt(skuNameBuffer.length() - 1);
        }
        return skuNameBuffer.toString();
    }

    public static void main(String[] args) {
//        List<GoodsSku> goodsSkuList = new ArrayList<>();
//        GoodsSku goodsSku = new GoodsSku();
//        goodsSku.setAttr("{\"color\":\"红色\",\"size\":\"XXL\"}");
//        GoodsSku goodsSku2 = new GoodsSku();
//        goodsSku2.setAttr("{\"color\":\"黑色\",\"size\":\"XXL\"}");
//        goodsSkuList.add(goodsSku);
//        goodsSkuList.add(goodsSku2);
//        List<Attr> attrList = sku2AttrList(goodsSkuList);
//        System.out.println(JSON.toJSONString(attrList));
        String attr = "{\"color\":\"黑色\",\"size\":\"XXL\"}";
        String skuName = getSkuNameV1(attr);
        System.out.println(skuName);
    }
}
