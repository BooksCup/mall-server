package com.bc.mall.server.service;

import com.bc.mall.server.entity.Goods;
import com.bc.mall.server.entity.GoodsAlbum;
import com.bc.mall.server.entity.GoodsSku;

import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author zhou
 */
public interface GoodsService {

    /**
     * 通过商品类别获取商品列表
     *
     * @param paramMap 参数map
     * @return 商品列表
     */
    List<Goods> getGoodsListByGoodsClass(Map<String, String> paramMap);

    /**
     * 获取猜你喜欢商品列表
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 猜你喜欢商品列表
     */
    List<Goods> getLikeGoodsList(int pageNum, int pageSize, Map<String, String> paramMap);

    /**
     * 通过商品ID获取商品
     *
     * @param paramMap 参数map
     * @return 商品
     */
    Goods getGoodsByGoodsId(Map<String, String> paramMap);

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
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 店铺下推荐商品列表
     */
    List<Goods> getRecommendGoodsListByShopId(int pageNum, int pageSize, Map<String, String> paramMap);

    /**
     * 获取店铺下所有商品列表
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 店铺下所有商品列表
     */
    List<Goods> getAllGoodsListByShopId(int pageNum, int pageSize, Map<String, String> paramMap);
}
