package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.Shop;
import com.bc.mall.server.service.ShopService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
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
            @PathVariable String shopId) {
        logger.info("[getShopDetail] storeId: " +
                storeId + ", shopId: " + shopId);
        ResponseEntity<Shop> responseEntity;
        try {
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            paramMap.put("shopId", shopId);
            Shop shop = shopService.getShopByShopId(paramMap);
            if (null != shop) {
                shop.setOnSaleGoodsNum(shopService.getShopOnSaleGoodsNum(shopId));
                shop.setTotalSalesVolume(shopService.getShopTotalSalesVolume(shopId));
            }
            responseEntity = new ResponseEntity<>(shop, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getShopDetail] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new Shop(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
