package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.group.GroupConfig;

import java.util.List;

/**
 * 拼团
 *
 * @author zhou
 */
public interface GroupMapper {

    /**
     * 根据店铺ID查找拼团配置列表
     *
     * @param storeId 店铺ID
     * @return 拼团配置列表
     */
    List<GroupConfig> getGroupConfigListByStoreId(String storeId);
}
