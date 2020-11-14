package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.UserCollection;

import java.util.List;
import java.util.Map;

/**
 * 用户收藏
 *
 * @author zhou
 */
public interface UserCollectionMapper {

    /**
     * 获取用户商品收藏列表(用于检查是否收藏某件商品)
     *
     * @param paramMap 参数map
     * @return 用户商品收藏列表
     */
    List<UserCollection> getUserGoodsCollectionListForCheck(Map<String, Object> paramMap);

    /**
     * 保存用户收藏
     *
     * @param userCollection 用户收藏
     */
    void saveUserCollection(UserCollection userCollection);
}
