package com.bc.mall.server.entity.auction;

/**
 * 竞拍
 *
 * @author zhou
 */
public class AuctionConfig {
    private String id;
    private String storeId;
    private Integer minBidderNum;
    private Integer waitTime;
    private Integer days;
    private String content;
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

    public Integer getMinBidderNum() {
        return minBidderNum;
    }

    public void setMinBidderNum(Integer minBidderNum) {
        this.minBidderNum = minBidderNum;
    }

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
