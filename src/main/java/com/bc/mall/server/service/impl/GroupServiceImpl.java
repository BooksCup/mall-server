package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.group.GroupConfig;
import com.bc.mall.server.mapper.GroupMapper;
import com.bc.mall.server.service.GroupService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 拼团
 *
 * @author zhou
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService {

    @Resource
    private GroupMapper groupMapper;

    /**
     * 根据店铺ID查找拼团配置
     *
     * @param storeId 店铺ID
     * @return 拼团配置
     */
    @Override
    public GroupConfig getGroupConfigByStoreId(String storeId) {
        List<GroupConfig> groupConfigList = groupMapper.getGroupConfigListByStoreId(storeId);
        if (!CollectionUtils.isEmpty(groupConfigList)) {
            return groupConfigList.get(0);
        }
        return null;
    }
}
