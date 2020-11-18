package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.*;
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

    @Resource
    private PluginService pluginService;

    @Resource
    private GoodsClassService goodsClassService;

    @Resource
    private GoodsService goodsService;

    @ApiOperation(value = "获取首页信息", notes = "获取首页信息")
    @GetMapping(value = "/home")
    public ResponseEntity<HomeProfile> getHomeProfile(@RequestParam String storeId,
                                                      @RequestParam String storeType,
                                                      @RequestParam(required = false) String token) {
        logger.info("[getHomeProfile] storeId: " + storeId + ", storeType: " + storeType +
                ", token: " + token);
        ResponseEntity<HomeProfile> responseEntity;
        HomeProfile homeProfile = new HomeProfile();
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            paramMap.put("storeType", storeType);
            List<Banner> bannerList = bannerService.getBannerList(paramMap);
            homeProfile.setBannerList(bannerList);

            paramMap.clear();
            paramMap.put("storeId", storeId);
            paramMap.put("state", Constant.PLUGIN_ENABLED);
            paramMap.put("isShow", Constant.PLUGIN_SHOW);
            List<Plugin> pluginList = pluginService.getPluginList(paramMap);
            homeProfile.setPluginList(pluginList);

            // 分类商品
            // 获取一级目录
            paramMap.clear();
            paramMap.put("storeId", storeId);
            paramMap.put("parentId", Constant.FIRST_CLASS_PARENT_ID);
            paramMap.put("deleteStatus", Constant.DELETE_STATUS_NOT);
            List<GoodsClass> goodsClassList = goodsClassService.getGoodsClassList(paramMap);
            for (GoodsClass goodsClass : goodsClassList) {
                paramMap.clear();
                paramMap.put("storeId", storeId);
                paramMap.put("goodsClassId", goodsClass.getId());
                List<Goods> goodsList = goodsService.getGoodsListByGoodsClass(paramMap);
                goodsClass.setGoodsList(goodsList);
            }
            homeProfile.setGoodsClassList(goodsClassList);

            // 猜你喜欢商品
            paramMap.clear();
            paramMap.put("storeId", storeId);
            List<Goods> likeGoodsList = goodsService.getLikeGoodsList(1, 10, paramMap);
            homeProfile.setLikeGoodsList(likeGoodsList);

            responseEntity = new ResponseEntity<>(homeProfile, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getHomeProfile] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new HomeProfile(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "获取个人信息", notes = "获取个人信息")
    @GetMapping(value = "/me")
    public ResponseEntity<MyProfile> getMyProfile(@RequestParam String storeId,
                                                  @RequestParam String storeType,
                                                  @RequestParam(required = false) String token) {
        logger.info("[getMyProfile] storeId: " + storeId + ", storeType: " + storeType +
                ", token: " + token);
        ResponseEntity<MyProfile> responseEntity;

        PluginState pluginState = getPluginState(storeId);
        try {
            responseEntity = new ResponseEntity<>(new MyProfile(pluginState), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getMyProfile] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new MyProfile(pluginState), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 获取店铺插件状态
     *
     * @param storeId 店铺ID
     * @return 店铺插件状态
     */
    private PluginState getPluginState(String storeId) {
        PluginState pluginState = new PluginState();
        Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
        paramMap.put("storeId", storeId);
        paramMap.put("state", Constant.PLUGIN_ENABLED);

        List<Plugin> pluginList = pluginService.getPluginList(paramMap);
        for (Plugin plugin : pluginList) {
            // 竞拍
            if (Constant.PLUGIN_CODE_AUCTION.equals(plugin.getCode())) {
                pluginState.setAuctionPluginState(Constant.PLUGIN_ENABLED);
            }

            // 分销
            if (Constant.PLUGIN_CODE_DISTRIBUTOR.equals(plugin.getCode())) {
                pluginState.setDistributorPluginState(Constant.PLUGIN_ENABLED);
            }

            // 积分商城
            if (Constant.PLUGIN_CODE_INTEGRAL.equals(plugin.getCode())) {
                pluginState.setIntegralPluginState(Constant.PLUGIN_ENABLED);
            }

            // 砍价
            if (Constant.PLUGIN_CODE_BARGAIN.equals(plugin.getCode())) {
                pluginState.setBargainPluginState(Constant.PLUGIN_ENABLED);
            }

            // 拼团
            if (Constant.PLUGIN_CODE_GROUP.equals(plugin.getCode())) {
                pluginState.setGroupPluginState(Constant.PLUGIN_ENABLED);
            }

            // 秒杀
            if (Constant.PLUGIN_CODE_SECKILL.equals(plugin.getCode())) {
                pluginState.setSeckillPluginState(Constant.PLUGIN_ENABLED);
            }
        }

        return pluginState;
    }
}
