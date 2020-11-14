package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.UserCollection;
import com.bc.mall.server.mapper.UserCollectionMapper;
import com.bc.mall.server.service.UserCollectionService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户收藏
 *
 * @author zhou
 */
@Service("userCollectionService")
public class UserCollectionServiceImpl implements UserCollectionService {

    @Resource
    private UserCollectionMapper userCollectionMapper;

    /**
     * 检查用户是否收藏某件商品
     *
     * @param paramMap 参数map
     * @return true: 已收藏 false: 未收藏
     */
    @Override
    public boolean checkUserGoodsCollectionExists(Map<String, Object> paramMap) {
        List<UserCollection> userCollectionList = userCollectionMapper.getUserGoodsCollectionListForCheck(paramMap);
        if (!CollectionUtils.isEmpty(userCollectionList)) {
            return true;
        }
        return false;
    }

    /**
     * 保存用户收藏
     *
     * @param userCollection 用户收藏
     */
    @Override
    public void saveUserCollection(UserCollection userCollection) {
        userCollectionMapper.saveUserCollection(userCollection);
    }

}
