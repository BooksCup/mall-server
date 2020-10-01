package com.bc.mall.server.entity.seckill;

/**
 * 秒杀
 *
 * @author zhou
 */
public class SeckillConfig {
    private String id;
    private String storeId;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
