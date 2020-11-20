package com.bc.mall.server.service;

import com.bc.mall.server.entity.UserCollection;

import java.util.Map;

/**
 * 用户收藏
 *
 * @author zhou
 */
public interface UserCollectionService {

    /**
     * 检查用户是否收藏某件商品
     *
     * @param paramMap 参数map
     * @return true: 已收藏 false: 未收藏
     */
    boolean checkUserGoodsCollectionExists(Map<String, Object> paramMap);

    /**
     * 保存用户收藏
     *
     * @param userCollection 用户收藏
     */
    void saveUserCollection(UserCollection userCollection);

    /**
     * 取消用户收藏
     *
     * @param paramMap 参数map
     */
    void cancelCollectGoods(Map<String, Object> paramMap);

}
