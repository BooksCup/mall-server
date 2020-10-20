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
}
