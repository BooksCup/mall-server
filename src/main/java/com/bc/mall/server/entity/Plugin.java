package com.bc.mall.server.entity;

/**
 * 插件
 *
 * @author zhou
 */
public class Plugin {
    /**
     * 竞拍插件状态
     */
    private String auctionPluginState;

    /**
     * 分销插件状态
     */
    private String distributorPluginState;

    /**
     * 积分商城插件状态
     */
    private String integralPluginState;

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
}
