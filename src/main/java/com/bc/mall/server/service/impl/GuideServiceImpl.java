package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.Guide;
import com.bc.mall.server.mapper.GuideMapper;
import com.bc.mall.server.service.GuideService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 引导图
 *
 * @author zhou
 */
@Service("guideService")
public class GuideServiceImpl implements GuideService {

    @Resource
    GuideMapper guideMapper;

    /**
     * 获取引导图列表
     *
     * @param paramMap 参数map
     * @return 引导图列表
     */
    @Override
    public List<Guide> getGuideList(Map<String, String> paramMap) {
        return guideMapper.getGuideList(paramMap);
    }
}
