package com.bc.mall.server.entity;

/**
 * 引导图
 * @author zhou
 */
public class Guide {
    private String guideId;
    private String storeId;
    private String guideImage;
    private String guideSource;
    private String guideType;
    private Integer guideSort;
    private String createTime;

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getGuideImage() {
        return guideImage;
    }

    public void setGuideImage(String guideImage) {
        this.guideImage = guideImage;
    }

    public String getGuideSource() {
        return guideSource;
    }

    public void setGuideSource(String guideSource) {
        this.guideSource = guideSource;
    }

    public String getGuideType() {
        return guideType;
    }

    public void setGuideType(String guideType) {
        this.guideType = guideType;
    }

    public Integer getGuideSort() {
        return guideSort;
    }

    public void setGuideSort(Integer guideSort) {
        this.guideSort = guideSort;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
