package com.bc.mall.server.entity;

/**
 * 我的信息
 *
 * @author zhou
 */
public class MyProfile extends BaseEntity {
    private PluginState pluginState;

    public MyProfile() {

    }

    public MyProfile(String responseCode, String responseMessage, PluginState pluginState) {
        super(responseCode, responseMessage);
        this.pluginState = pluginState;
    }

    public MyProfile(PluginState pluginState) {
        this.pluginState = pluginState;
    }

    public PluginState getPluginState() {
        return pluginState;
    }

    public void setPluginState(PluginState pluginState) {
        this.pluginState = pluginState;
    }
}
