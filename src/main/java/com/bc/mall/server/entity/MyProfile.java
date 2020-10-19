package com.bc.mall.server.entity;

/**
 * 我的信息
 *
 * @author zhou
 */
public class MyProfile extends BaseEntity {
    private Plugin plugin;

    public MyProfile() {

    }

    public MyProfile(String responseCode, String responseMessage, Plugin plugin) {
        super(responseCode, responseMessage);
        this.plugin = plugin;
    }

    public MyProfile(Plugin plugin) {
        this.plugin = plugin;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }
}
