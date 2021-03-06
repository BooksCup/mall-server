package com.bc.mall.server.service;

import com.bc.mall.server.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * 评论
 * @author zhou
 */
public interface CommentService {

    /**
     * 根据商品ID查找评论列表
     *
     * @param paramMap 参数map
     * @return 评论列表
     */
    List<Comment> getCommentListByGoodsId(Map<String, Object> paramMap);
}
