package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.UserCollection;
import com.bc.mall.server.mapper.UserCollectionMapper;
import com.bc.mall.server.service.UserCollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
     * 保存用户收藏
     *
     * @param userCollection 用户收藏
     */
    @Override
    public void saveUserCollection(UserCollection userCollection) {
        userCollectionMapper.saveUserCollection(userCollection);
    }

}
