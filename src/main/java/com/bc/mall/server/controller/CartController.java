package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.*;
import com.bc.mall.server.enums.ResponseMsg;
import com.bc.mall.server.service.CartService;
import com.bc.mall.server.service.GoodsService;
import com.bc.mall.server.service.GoodsSkuService;
import com.bc.mall.server.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车
 *
 * @author zhou
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Resource
    private UserService userService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private GoodsSkuService goodsSkuService;

    @Resource
    private CartService cartService;

    /**
     * 加入购物车
     *
     * @param storeId    店铺ID
     * @param storeType  店铺类型
     * @param goodsId    商品ID
     * @param token      token
     * @param goodsNum   商品数量
     * @param goodsSkuId skuID
     * @return ResponseEntity
     */
    @ApiOperation(value = "加入购物车", notes = "加入购物车")
    @PostMapping(value = "")
    public ResponseEntity<Cart> addToCart(
            @RequestParam String storeId,
            @RequestParam String storeType,
            @RequestParam String goodsId,
            @RequestParam String token,
            @RequestParam Integer goodsNum,
            @RequestParam String goodsSkuId) {
        logger.info("[addToCart] goodsId: " + goodsId + ", number: " + goodsNum +
                ", goodsSkuId: " + goodsSkuId + ", storeId: " + storeId + ", storeType: " + storeType + ", token: " + token);
        ResponseEntity<Cart> responseEntity;
        try {
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("goodsId", goodsId);
            paramMap.put("storeId", storeId);
            Goods goods = goodsService.getGoodsByGoodsId(paramMap);
            if (null == goods) {
                // 商品不存在
                return new ResponseEntity<>(new Cart(ResponseMsg.PARAM_ILLEGAL.getResponseCode(),
                        ResponseMsg.PARAM_ILLEGAL.getResponseMessage()), HttpStatus.BAD_REQUEST);
            } else {
                if (!Constant.GOODS_STATUS_SHELVE.equals(goods.getStatus())) {
                    // 商品未上架
                    return new ResponseEntity<>(new Cart(ResponseMsg.GOODS_OFF_SHELVE.getResponseCode(),
                            ResponseMsg.GOODS_OFF_SHELVE.getResponseMessage()), HttpStatus.BAD_REQUEST);
                }

                GoodsSku goodsSku = goodsSkuService.getGoodsSkuBySkuId(goodsSkuId);
                if (null != goodsSku) {
                    Integer remainStock = goodsSku.getRemainStock();
                    if (goodsNum > remainStock) {
                        // 库存不足
                        return new ResponseEntity<>(new Cart(ResponseMsg.STOCK_NOT_ENOUGH.getResponseCode(),
                                ResponseMsg.STOCK_NOT_ENOUGH.getResponseMessage()), HttpStatus.BAD_REQUEST);
                    }
                } else {
                    // sku不存在
                    return new ResponseEntity<>(new Cart(ResponseMsg.PARAM_ILLEGAL.getResponseCode(),
                            ResponseMsg.PARAM_ILLEGAL.getResponseMessage()), HttpStatus.BAD_REQUEST);
                }
            }

            paramMap.clear();
            paramMap.put("storeId", storeId);
            paramMap.put("token", token);
            List<User> userList = userService.getUserListByToken(paramMap);
            if (CollectionUtils.isEmpty(userList)) {
            } else {
                User user = userList.get(0);
                Cart cart = new Cart(storeId, goodsId, goodsSkuId, user.getId(), goodsNum);
                cartService.saveCart(cart);
            }
            responseEntity = new ResponseEntity<>(new Cart(ResponseMsg.ADD_TO_CART_SUCCESS.getResponseCode(),
                    ResponseMsg.ADD_TO_CART_SUCCESS.getResponseMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[addToCart] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new Cart(ResponseMsg.SERVER_ERROR.getResponseCode(),
                    ResponseMsg.SERVER_ERROR.getResponseMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }

    /**
     * 立即购买
     * 做各种商品校验，结果带回前端，生成订单的前一步
     *
     * @param goodsId    商品ID
     * @param number     商品数量
     * @param goodsSkuId 商品规格ID
     * @param storeId    店铺ID
     * @return ResponseEntity<String>
     */
    @ApiOperation(value = "立即购买", notes = "立即购买")
    @PostMapping(value = "/buyNow")
    public ResponseEntity<BaseResponse> buyNow(
            @RequestParam String goodsId,
            @RequestParam Integer number,
            @RequestParam(required = false) String goodsSkuId,
            @RequestParam String storeId) {
        logger.info("[buyNow] goodsId: " + goodsId + ", number: " + number +
                ", goodsSkuId: " + goodsSkuId + ", storeId: " + storeId);
        ResponseEntity<BaseResponse> responseEntity;
        try {
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("goodsId", goodsId);
            paramMap.put("storeId", storeId);
            Goods goods = goodsService.getGoodsByGoodsId(paramMap);
            if (null == goods) {
                // 商品不存在
                return new ResponseEntity<>(new BaseResponse(ResponseMsg.PARAM_ILLEGAL.getResponseCode(),
                        ResponseMsg.PARAM_ILLEGAL.getResponseMessage()), HttpStatus.BAD_REQUEST);
            } else {
                if (!Constant.GOODS_STATUS_SHELVE.equals(goods.getStatus())) {
                    // 商品未上架
                    return new ResponseEntity<>(new BaseResponse(ResponseMsg.GOODS_OFF_SHELVE.getResponseCode(),
                            ResponseMsg.GOODS_OFF_SHELVE.getResponseMessage()), HttpStatus.BAD_REQUEST);
                }

                GoodsSku goodsSku = goodsSkuService.getGoodsSkuBySkuId(goodsSkuId);
                if (null != goodsSku) {
                    Integer remainStock = goodsSku.getRemainStock();
                    if (number > remainStock) {
                        // 库存不足
                        return new ResponseEntity<>(new BaseResponse(ResponseMsg.STOCK_NOT_ENOUGH.getResponseCode(),
                                ResponseMsg.STOCK_NOT_ENOUGH.getResponseMessage()), HttpStatus.BAD_REQUEST);
                    }
                } else {
                    // sku不存在
                    return new ResponseEntity<>(new BaseResponse(ResponseMsg.PARAM_ILLEGAL.getResponseCode(),
                            ResponseMsg.PARAM_ILLEGAL.getResponseMessage()), HttpStatus.BAD_REQUEST);
                }

            }
            responseEntity = new ResponseEntity<>(new BaseResponse(ResponseMsg.BUY_NOW_SUCCESS.getResponseCode(),
                    ResponseMsg.BUY_NOW_SUCCESS.getResponseMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[buyNow] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new BaseResponse(ResponseMsg.SERVER_ERROR.getResponseCode(),
                    ResponseMsg.SERVER_ERROR.getResponseMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
