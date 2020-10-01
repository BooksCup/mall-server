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

    /**
     * 砍价插件状态
     */
    private String bargainPluginState;

    /**
     * 拼团插件状态
     */
    private String groupPluginState;

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
}
