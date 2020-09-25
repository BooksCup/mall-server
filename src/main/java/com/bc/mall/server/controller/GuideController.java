package com.bc.mall.server.controller;

import com.bc.mall.server.entity.Guide;
import com.bc.mall.server.service.GuideService;
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
 * 引导图
 *
 * @author zhou
 */
@RestController
@RequestMapping("/guides")
public class GuideController {

    @Resource
    private GuideService guideService;

    private static final Logger logger = LoggerFactory.getLogger(GuideController.class);

    /**
     * 获取引导图列表
     *
     * @param storeId   店铺ID
     * @param storeType 店铺类型
     * @return ResponseEntity<String>
     */
    @ApiOperation(value = "获取引导图列表", notes = "获取引导图列表")
    @GetMapping(value = "")
    public ResponseEntity<List<Guide>> getGuideList(@RequestParam String storeId, @RequestParam String storeType) {
        logger.info("[getGuideList] storeId: " + storeId + ", storeType: " + storeType);
        ResponseEntity<List<Guide>> responseEntity;
        try {
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("storeId", storeId);
            paramMap.put("storeType", storeType);
            List<Guide> guideList = guideService.getGuideList(paramMap);
            responseEntity = new ResponseEntity<>(guideList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getGuideList] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
