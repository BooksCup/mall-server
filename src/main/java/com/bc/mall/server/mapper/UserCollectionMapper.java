package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.UserCollection;

/**
 * 用户收藏
 *
 * @author zhou
 */
public interface UserCollectionMapper {

    /**
     * 保存用户收藏
     *
     * @param userCollection 用户收藏
     */
    void saveUserCollection(UserCollection userCollection);
}
