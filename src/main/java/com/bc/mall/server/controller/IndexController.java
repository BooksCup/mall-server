package com.bc.mall.server.controller;


import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.*;
import com.bc.mall.server.entity.auction.AuctionConfig;
import com.bc.mall.server.entity.distributor.DistributorConfig;
import com.bc.mall.server.entity.integral.IntegralConfig;
import com.bc.mall.server.service.AuctionService;
import com.bc.mall.server.service.DistributorService;
import com.bc.mall.server.service.IntegralService;
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

/**
 * 导航
 *
 * @author zhou
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private AuctionService auctionService;

    @Resource
    private DistributorService distributorService;

    @Resource
    private IntegralService integralService;

    @ApiOperation(value = "获取个人信息", notes = "获取个人信息")
    @GetMapping(value = "/me")
    public ResponseEntity<MyProfile> getMyProfile(@RequestParam String storeId,
                                                  @RequestParam String storeType,
                                                  @RequestParam(required = false) String token) {
        logger.info("[getMyProfile] storeId: " + storeId + ", storeType: " + storeType +
                ", token: " + token);
        ResponseEntity<MyProfile> responseEntity;

        Plugin plugin = getStorePlugin(storeId);
        try {
//            if (StringUtils.isEmpty(token)) {
//                return new ResponseEntity<>(
//                        new MyProfile(ResponseMsg.NOT_LOGIN.getResponseCode(), ResponseMsg.NOT_LOGIN.getResponseMessage(), plugin),
//                        HttpStatus.BAD_REQUEST);
//            } else {
//
//            }
            responseEntity = new ResponseEntity<>(new MyProfile(plugin), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getMyProfile] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new MyProfile(plugin), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 获取店铺插件
     *
     * @param storeId 店铺ID
     * @return 店铺插件
     */
    private Plugin getStorePlugin(String storeId) {
        Plugin plugin = new Plugin();
        // 插件
        // 竞拍
        AuctionConfig auctionConfig = auctionService.getAuctionConfigByStoreId(storeId);
        if (null != auctionConfig && Constant.PLUGIN_ENABLED.equals(auctionConfig.getState())) {
            plugin.setAuctionPluginState(Constant.PLUGIN_ENABLED);
        } else {
            plugin.setAuctionPluginState(Constant.PLUGIN_DISABLED);
        }

        // 分销
        DistributorConfig distributorConfig = distributorService.getDistributorConfigByStoreId(storeId);
        if (null != distributorConfig && Constant.PLUGIN_ENABLED.equals(distributorConfig.getState())) {
            plugin.setDistributorPluginState(Constant.PLUGIN_ENABLED);
        } else {
            plugin.setDistributorPluginState(Constant.PLUGIN_DISABLED);
        }

        // 积分商城
        IntegralConfig integralConfig = integralService.getIntegralConfigByStoreId(storeId);
        if (null != integralConfig && Constant.PLUGIN_ENABLED.equals(integralConfig.getState())) {
            plugin.setIntegralPluginState(Constant.PLUGIN_ENABLED);
        } else {
            plugin.setIntegralPluginState(Constant.PLUGIN_DISABLED);
        }
        return plugin;
    }
}
