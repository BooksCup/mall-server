package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.EntityStore;
import com.bc.mall.server.entity.Goods;
import com.bc.mall.server.entity.GoodsClass;
import com.bc.mall.server.entity.Shop;
import com.bc.mall.server.service.GoodsClassService;
import com.bc.mall.server.service.GoodsService;
import com.bc.mall.server.service.ShopService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 店铺
 *
 * @author zhou
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Resource
    private ShopService shopService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private GoodsClassService goodsClassService;

    /**
     * 获取店铺详情
     *
     * @param storeId 商城ID
     * @param shopId  店铺ID
     * @return ResponseEntity<Goods>
     */
    @ApiOperation(value = "获取店铺详情", notes = "获取店铺详情")
    @GetMapping(value = "/{shopId}")
    public ResponseEntity<Shop> getShopDetail(
            @RequestParam(required = false) String token,
            @RequestParam String storeId,
            @RequestParam(required = false, defaultValue = Constant.SHOP_TAB_RECOMMEND) String tab,
            @PathVariable String shopId) {
        logger.info("[getShopDetail] storeId: " +
                storeId + ", shopId: " + shopId + ", tab: " + tab);
        ResponseEntity<Shop> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            paramMap.put("shopId", shopId);
            Shop shop = shopService.getShopByShopId(paramMap);
            if (null != shop) {
                shop.setOnSaleGoodsNum(shopService.getShopOnSaleGoodsNum(shopId));
                shop.setTotalSalesVolume(shopService.getShopTotalSalesVolume(shopId));

                List<EntityStore> entityStoreList = shopService.getEntityStoreListByShopId(paramMap);
                shop.setEntityStoreList(entityStoreList);

                if (Constant.SHOP_TAB_RECOMMEND.equals(tab)) {
                    List<Goods> goodsList = goodsService.getRecommendGoodsListByShopId(1, 10, paramMap);
                    shop.setGoodsList(goodsList);
                } else if (Constant.SHOP_TAB_ALL_GOODS.equals(tab)) {
                    List<Goods> goodsList = goodsService.getAllGoodsListByShopId(1, 10, paramMap);
                    shop.setGoodsList(goodsList);
                } else if (Constant.SHOP_TAB_GOODS_CLASS.equals(tab)) {
                    // 获取一级目录
                    paramMap.clear();
                    paramMap.put("storeId", storeId);
                    paramMap.put("parentId", Constant.FIRST_CLASS_PARENT_ID);
                    paramMap.put("deleteStatus", Constant.DELETE_STATUS_NOT);
                    List<GoodsClass> goodsClassList = goodsClassService.getGoodsClassList(paramMap);
                    shop.setGoodsClassList(goodsClassList);
                }
            }
            responseEntity = new ResponseEntity<>(shop, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getShopDetail] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new Shop(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 获取店铺商品列表
     *
     * @param tab     店铺详情页tab
     * @param storeId 商城ID
     * @param shopId  店铺ID
     * @param page    当前分页数
     * @param limit   分页大小
     * @return ResponseEntity
     */
    @ApiOperation(value = "获取店铺商品列表", notes = "获取店铺商品列表")
    @GetMapping(value = "/{shopId}/goods")
    public ResponseEntity<List<Goods>> getShopGoodsList(
            @RequestParam(required = false, defaultValue = Constant.SHOP_TAB_RECOMMEND) String tab,
            @RequestParam String storeId,
            @PathVariable String shopId,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        logger.info("[getShopGoodsList] storeId: " +
                storeId + ", shopId: " + shopId + ", page: " + page + ", limit: " + limit);
        ResponseEntity<List<Goods>> responseEntity;
        List<Goods> goodsList = new ArrayList<>();
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            paramMap.put("shopId", shopId);

            if (Constant.SHOP_TAB_RECOMMEND.equals(tab)) {
                goodsList = goodsService.getRecommendGoodsListByShopId(page, limit, paramMap);
            } else if (Constant.SHOP_TAB_ALL_GOODS.equals(tab)) {
                goodsList = goodsService.getAllGoodsListByShopId(page, limit, paramMap);
            }
            responseEntity = new ResponseEntity<>(goodsList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getShopGoodsList] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
