package com.bc.mall.server.service;

import com.bc.mall.server.entity.Guide;

import java.util.List;
import java.util.Map;

/**
 * 引导图
 *
 * @author zhou
 */
public interface GuideService {
    /**
     * 获取引导图列表
     *
     * @param paramMap 参数map
     * @return 引导图列表
     */
    List<Guide> getGuideList(Map<String, String> paramMap);
}
