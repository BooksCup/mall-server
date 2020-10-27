package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.Goods;
import com.bc.mall.server.entity.GoodsAlbum;
import com.bc.mall.server.mapper.GoodsMapper;
import com.bc.mall.server.service.GoodsService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author zhou
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 通过商品类别获取商品列表
     *
     * @param paramMap 参数map
     * @return 商品列表
     */
    @Override
    public List<Goods> getGoodsListByGoodsClass(Map<String, String> paramMap) {
        return goodsMapper.getGoodsListByGoodsClass(paramMap);
    }

    /**
     * 获取猜你喜欢商品列表
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 猜你喜欢商品列表
     */
    @Override
    public List<Goods> getLikeGoodsList(int pageNum, int pageSize, Map<String, String> paramMap) {
        PageHelper.startPage(pageNum, pageSize);
        return goodsMapper.getLikeGoodsList(paramMap);
    }

    /**
     * 通过商品ID获取商品
     *
     * @param paramMap 参数map
     * @return 商品
     */
    @Override
    public Goods getGoodsByGoodsId(Map<String, String> paramMap) {
        List<Goods> goodsList = goodsMapper.getGoodsListByGoodsId(paramMap);
        if (!CollectionUtils.isEmpty(goodsList)) {
            return goodsList.get(0);
        }
        return null;
    }

    /**
     * 通过商品ID获取商品图片列表
     *
     * @param goodsId 商品ID
     * @return 商品图片列表
     */
    @Override
    public List<GoodsAlbum> getGoodsAlbumListByGoodsId(String goodsId){
        return goodsMapper.getGoodsAlbumListByGoodsId(goodsId);
    }
}
