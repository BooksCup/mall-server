package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.Goods;
import com.bc.mall.server.entity.GoodsAlbum;

import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author zhou
 */
public interface GoodsMapper {

    /**
     * 通过商品类别获取商品列表
     *
     * @param paramMap 参数map
     * @return 商品列表
     */
    List<Goods> getGoodsListByGoodsClass(Map<String, Object> paramMap);

    /**
     * 获取猜你喜欢商品列表
     *
     * @param paramMap 参数map
     * @return 猜你喜欢商品列表
     */
    List<Goods> getLikeGoodsList(Map<String, Object> paramMap);

    /**
     * 通过商品ID获取商品列表
     *
     * @param paramMap 参数map
     * @return 商品列表
     */
    List<Goods> getGoodsListByGoodsId(Map<String, Object> paramMap);

    /**
     * 通过商品ID获取商品图片列表
     *
     * @param goodsId 商品ID
     * @return 商品图片列表
     */
    List<GoodsAlbum> getGoodsAlbumListByGoodsId(String goodsId);

    /**
     * 获取店铺下推荐商品列表
     *
     * @param paramMap 参数map
     * @return 店铺下推荐商品列表
     */
    List<Goods> getRecommendGoodsListByShopId(Map<String, Object> paramMap);

    /**
     * 获取店铺下所有商品列表
     *
     * @param paramMap 参数map
     * @return 店铺下所有商品列表
     */
    List<Goods> getAllGoodsListByShopId(Map<String, Object> paramMap);
}
