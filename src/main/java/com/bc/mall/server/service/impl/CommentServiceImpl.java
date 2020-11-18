package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.Comment;
import com.bc.mall.server.mapper.CommentMapper;
import com.bc.mall.server.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 评价
 *
 * @author zhou
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    /**
     * 根据商品ID查找评论列表
     *
     * @param paramMap 参数map
     * @return 评论列表
     */
    @Override
    public List<Comment> getCommentListByGoodsId(Map<String, Object> paramMap) {
        return commentMapper.getCommentListByGoodsId(paramMap);
    }
}
