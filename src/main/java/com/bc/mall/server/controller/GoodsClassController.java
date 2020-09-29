package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.GoodsClass;
import com.bc.mall.server.service.GoodsClassService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/goodsClass")
public class GoodsClassController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsClassController.class);

    @Resource
    private GoodsClassService goodsClassService;

    /**
     * 获取商品类别列表
     *
     * @param storeId 商城ID
     * @return ResponseEntity
     */
    @ApiOperation(value = "获取商品类别列表", notes = "获取商品类别列表")
    @GetMapping(value = "")
    public ResponseEntity<List<GoodsClass>> getGoodsClassList(@RequestParam String storeId) {
        logger.info("[getGoodsClassList] storeId: " + storeId);
        ResponseEntity<List<GoodsClass>> responseEntity;
        try {
            // 获取一级目录
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            paramMap.put("parentId", Constant.FIRST_CLASS_PARENT_ID);
            paramMap.put("deleteStatus", Constant.DELETE_STATUS_NOT);
            List<GoodsClass> goodsClassList = goodsClassService.getGoodsClassList(paramMap);

            for (GoodsClass goodsClass : goodsClassList) {
                paramMap.put("parentId", goodsClass.getId());
                List<GoodsClass> subGoodsClassList = goodsClassService.getGoodsClassList(paramMap);
                goodsClass.setSubGoodsClassList(subGoodsClassList);
            }

            responseEntity = new ResponseEntity<>(goodsClassList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getGoodsClassList] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
