package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.*;
import com.bc.mall.server.service.CommentService;
import com.bc.mall.server.service.GoodsService;
import com.bc.mall.server.service.ShopService;
import com.bc.mall.server.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品类别
 *
 * @author zhou
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

    @Resource
    private ShopService shopService;

    @Resource
    private CommentService commentService;

    @Resource
    private UserService userService;

    /**
     * 获取猜你喜欢商品列表
     *
     * @param storeId 商城ID
     * @param page    当前分页数
     * @param limit   分页大小
     * @return ResponseEntity
     */
    @ApiOperation(value = "获取猜你喜欢商品列表", notes = "获取猜你喜欢商品列表")
    @GetMapping(value = "")
    public ResponseEntity<List<Goods>> getLikeGoodsList(
            @RequestParam String storeId,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        logger.info("[getLikeGoodsList] storeId: " +
                storeId + ", page: " + page + ", limit: " + limit);
        ResponseEntity<List<Goods>> responseEntity;
        try {
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            List<Goods> likeGoodsList = goodsService.getLikeGoodsList(page, limit, paramMap);
            responseEntity = new ResponseEntity<>(likeGoodsList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getLikeGoodsList] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 获取商品详情
     *
     * @param storeId 商城ID
     * @param goodsId 商品ID
     * @return ResponseEntity<Goods>
     */
    @ApiOperation(value = "获取商品详情", notes = "获取商品详情")
    @GetMapping(value = "/{goodsId}")
    public ResponseEntity<Goods> getGoodsDetail(
            @RequestParam(required = false) String token,
            @RequestParam String storeId,
            @PathVariable String goodsId) {
        logger.info("[getGoodsDetail] storeId: " +
                storeId + ", goodsId: " + goodsId);
        ResponseEntity<Goods> responseEntity;
        try {
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            paramMap.put("goodsId", goodsId);
            Goods goods = goodsService.getGoodsByGoodsId(paramMap);

            // 获取商品图片
            List<GoodsAlbum> goodsAlbumList = goodsService.getGoodsAlbumListByGoodsId(goodsId);
            goods.setGoodsAlbumList(goodsAlbumList);

            // 获取商品价格
            GoodsSku goodsPrice = goodsService.getGoodsPrice(goodsId);
            if (null != goodsPrice.getMaxSellPrice() &&
                    goodsPrice.getMaxSellPrice().equals(goodsPrice.getMinSellPrice())) {
                goods.setSellPrice(goodsPrice.getMaxSellPrice());
            } else {
                goods.setSellPrice(goodsPrice.getMinSellPrice() + "-" + goodsPrice.getMaxSellPrice());
            }

            // 获取商品评论
            List<Comment> commentList = commentService.getCommentListByGoodsId(paramMap);
            goods.setCommentList(commentList);

            // 商品收藏
            if (StringUtils.isEmpty(token)) {
                // 未登录
                goods.setIsCollected(Constant.IS_COLLECTED_NO);
            } else {
                paramMap.clear();
                paramMap.put("storeId", storeId);
                paramMap.put("token", token);
                List<User> userList = userService.getUserListByToken(paramMap);
                if (CollectionUtils.isEmpty(userList)) {
                    // 未登录
                    goods.setIsCollected(Constant.IS_COLLECTED_NO);
                } else {
                    paramMap.clear();
                    paramMap.put("userId", userList.get(0).getId());
                    paramMap.put("goodsId", goodsId);
                    if (userService.checkUserGoodsCollectionExists(paramMap)) {
                        goods.setIsCollected(Constant.IS_COLLECTED_YES);
                    } else {
                        goods.setIsCollected(Constant.IS_COLLECTED_NO);
                    }
                }
            }

            // 店铺信息
            if (!StringUtils.isEmpty(goods.getShopId())){
                paramMap.clear();
                paramMap.put("storeId", storeId);
                paramMap.put("shopId", goods.getShopId());
                Shop shop = shopService.getShopByShopId(paramMap);
                goods.setShop(shop);
            }

            responseEntity = new ResponseEntity<>(goods, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getGoodsDetail] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new Goods(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
