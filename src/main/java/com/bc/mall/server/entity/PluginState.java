package com.bc.mall.server.entity;

import com.bc.mall.server.cons.Constant;

/**
 * 插件状态
 *
 * @author zhou
 */
public class PluginState {
    /**
     * 竞拍插件状态
     */
    private String auctionPluginState = Constant.PLUGIN_DISABLED;

    /**
     * 分销插件状态
     */
    private String distributorPluginState = Constant.PLUGIN_DISABLED;

    /**
     * 积分商城插件状态
     */
    private String integralPluginState = Constant.PLUGIN_DISABLED;

    /**
     * 砍价插件状态
     */
    private String bargainPluginState = Constant.PLUGIN_DISABLED;

    /**
     * 拼团插件状态
     */
    private String groupPluginState = Constant.PLUGIN_DISABLED;

    /**
     * 秒杀插件状态
     */
    private String seckillPluginState = Constant.PLUGIN_DISABLED;

    public String getAuctionPluginState() {
        return auctionPluginState;
    }

    public void setAuctionPluginState(String auctionPluginState) {
        this.auctionPluginState = auctionPluginState;
    }

    public String getDistributorPluginState() {
        return distributorPluginState;
    }

    public void setDistributorPluginState(String distributorPluginState) {
        this.distributorPluginState = distributorPluginState;
    }

    public String getIntegralPluginState() {
        return integralPluginState;
    }

    public void setIntegralPluginState(String integralPluginState) {
        this.integralPluginState = integralPluginState;
    }

    public String getBargainPluginState() {
        return bargainPluginState;
    }

    public void setBargainPluginState(String bargainPluginState) {
        this.bargainPluginState = bargainPluginState;
    }

    public String getGroupPluginState() {
        return groupPluginState;
    }

    public void setGroupPluginState(String groupPluginState) {
        this.groupPluginState = groupPluginState;
    }

    public String getSeckillPluginState() {
        return seckillPluginState;
    }

    public void setSeckillPluginState(String seckillPluginState) {
        this.seckillPluginState = seckillPluginState;
    }
}
