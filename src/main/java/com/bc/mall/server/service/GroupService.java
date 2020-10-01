package com.bc.mall.server.service;

import com.bc.mall.server.entity.group.GroupConfig;

/**
 * 拼团
 *
 * @author zhou
 */
public interface GroupService {

    /**
     * 根据店铺ID查找拼团配置
     *
     * @param storeId 店铺ID
     * @return 拼团配置
     */
    GroupConfig getGroupConfigByStoreId(String storeId);
}
