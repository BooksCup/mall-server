package com.bc.mall.server.entity;

import java.util.List;

/**
 * 商品属性
 *
 * @author zhou
 */
public class Attr {
    private String id;
    private String attrName;
    private String attrType;
    private List<String> all;

    private String attributeId;
    private String attributeValue;
    private boolean enable;
    private boolean select;

    private List<Attr> attr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public List<String> getAll() {
        return all;
    }

    public void setAll(List<String> all) {
        this.all = all;
    }

    public List<Attr> getAttr() {
        return attr;
    }

    public void setAttr(List<Attr> attr) {
        this.attr = attr;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
