package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.*;
import com.bc.mall.server.entity.auction.AuctionConfig;
import com.bc.mall.server.entity.bargain.BargainConfig;
import com.bc.mall.server.entity.distributor.DistributorConfig;
import com.bc.mall.server.entity.group.GroupConfig;
import com.bc.mall.server.entity.integral.IntegralConfig;
import com.bc.mall.server.entity.seckill.SeckillConfig;
import com.bc.mall.server.service.*;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private BannerService bannerService;

    @Resource
    private AuctionService auctionService;

    @Resource
    private DistributorService distributorService;

    @Resource
    private IntegralService integralService;

    @Resource
    private BargainService bargainService;

    @Resource
    private GroupService groupService;

    @Resource
    private SeckillService seckillService;

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

    @ApiOperation(value = "获取首页信息", notes = "获取首页信息")
    @GetMapping(value = "/home")
    public ResponseEntity<HomeProfile> getHomeProfile(@RequestParam String storeId,
                                                  @RequestParam String storeType,
                                                  @RequestParam(required = false) String token) {
        logger.info("[HomeProfile] storeId: " + storeId + ", storeType: " + storeType +
                ", token: " + token);
        ResponseEntity<HomeProfile> responseEntity;
        HomeProfile homeProfile = new HomeProfile();
        try {
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("storeId", storeId);
            paramMap.put("storeType", storeType);
            List<Banner> bannerList = bannerService.getBannerList(paramMap);
            homeProfile.setBannerList(bannerList);

            responseEntity = new ResponseEntity<>(homeProfile, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[HomeProfile] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new HomeProfile(), HttpStatus.INTERNAL_SERVER_ERROR);
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

        // 砍价
        BargainConfig bargainConfig = bargainService.getBargainConfigByStoreId(storeId);
        if (null != bargainConfig && Constant.PLUGIN_ENABLED.equals(bargainConfig.getState())) {
            plugin.setBargainPluginState(Constant.PLUGIN_ENABLED);
        } else {
            plugin.setBargainPluginState(Constant.PLUGIN_DISABLED);
        }

        // 拼团
        GroupConfig groupConfig = groupService.getGroupConfigByStoreId(storeId);
        if (null != groupConfig && Constant.PLUGIN_ENABLED.equals(groupConfig.getState())) {
            plugin.setGroupPluginState(Constant.PLUGIN_ENABLED);
        } else {
            plugin.setGroupPluginState(Constant.PLUGIN_DISABLED);
        }

        // 秒杀
        SeckillConfig seckillConfig = seckillService.getSeckillConfigByStoreId(storeId);
        if (null != seckillConfig && Constant.PLUGIN_ENABLED.equals(seckillConfig.getState())) {
            plugin.setSeckillPluginState(Constant.PLUGIN_ENABLED);
        } else {
            plugin.setSeckillPluginState(Constant.PLUGIN_DISABLED);
        }

        return plugin;
    }
}
