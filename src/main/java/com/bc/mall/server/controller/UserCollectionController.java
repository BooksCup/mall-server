package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.*;
import com.bc.mall.server.enums.ResponseMsg;
import com.bc.mall.server.service.UserCollectionService;
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
 * 用户收藏
 *
 * @author zhou
 */
@RestController
@RequestMapping("/userCollection")
public class UserCollectionController {

    private static final Logger logger = LoggerFactory.getLogger(UserCollectionController.class);

    @Resource
    private UserCollectionService userCollectionService;

    /**
     * 收藏商品
     *
     * @param storeId 商城ID
     * @param userId  用户ID
     * @param goodsId 商品ID
     * @return ResponseEntity<UserCollection>
     */
    @ApiOperation(value = "收藏商品", notes = "收藏商品")
    @PostMapping(value = "/collectGoods")
    public ResponseEntity<UserCollection> collectGoods(
            @RequestParam String storeId,
            @RequestParam String userId,
            @RequestParam String goodsId) {
        logger.info("[collectGoods] storeId: " +
                storeId + ", userId: " + userId + ", goodsId: " + goodsId);
        ResponseEntity<UserCollection> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            paramMap.put("userId", userId);
            paramMap.put("goodsId", goodsId);
            if (userCollectionService.checkUserGoodsCollectionExists(paramMap)) {
                return new ResponseEntity<>(new UserCollection(
                        ResponseMsg.COLLECTION_EXISTS.getResponseCode(),
                        ResponseMsg.COLLECTION_EXISTS.getResponseMessage()),
                        HttpStatus.BAD_REQUEST);
            }
            UserCollection userCollection = new UserCollection(storeId, userId,
                    Constant.USER_COLLECTION_TYPE_GOODS, null, goodsId);
            userCollectionService.saveUserCollection(userCollection);

            userCollection.setResponseCode(ResponseMsg.COLLECT_SUCCESS.getResponseCode());
            userCollection.setResponseMessage(ResponseMsg.COLLECT_SUCCESS.getResponseMessage());
            responseEntity = new ResponseEntity<>(userCollection, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[collectGoods] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new UserCollection(
                    ResponseMsg.SERVER_ERROR.getResponseCode(),
                    ResponseMsg.SERVER_ERROR.getResponseMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 取消收藏商品
     *
     * @param storeId 商城ID
     * @param userId  用户ID
     * @param goodsId 商品ID
     * @return ResponseEntity<UserCollection>
     */
    @ApiOperation(value = "取消收藏商品", notes = "取消收藏商品")
    @PostMapping(value = "/cancelCollectGoods")
    public ResponseEntity<UserCollection> cancelCollectGoods(
            @RequestParam String storeId,
            @RequestParam String userId,
            @RequestParam String goodsId) {
        logger.info("[cancelCollectGoods] storeId: " +
                storeId + ", userId: " + userId + ", goodsId: " + goodsId);
        ResponseEntity<UserCollection> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            paramMap.put("userId", userId);
            paramMap.put("goodsId", goodsId);

            userCollectionService.cancelCollectGoods(paramMap);
            responseEntity = new ResponseEntity<>(new UserCollection(
                    ResponseMsg.CANCEL_COLLECT_SUCCESS.getResponseCode(),
                    ResponseMsg.CANCEL_COLLECT_SUCCESS.getResponseMessage()),
                    HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[cancelCollectGoods] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new UserCollection(
                    ResponseMsg.SERVER_ERROR.getResponseCode(),
                    ResponseMsg.SERVER_ERROR.getResponseMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
