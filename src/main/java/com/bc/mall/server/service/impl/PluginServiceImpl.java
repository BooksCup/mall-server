package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.Plugin;
import com.bc.mall.server.mapper.PluginMapper;
import com.bc.mall.server.service.PluginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 插件
 *
 * @author zhou
 */
@Service("pluginService")
public class PluginServiceImpl implements PluginService {
    @Resource
    private PluginMapper pluginMapper;

    /**
     * 获取插件列表
     *
     * @param paramMap 参数map
     * @return 插件列表
     */
    @Override
    public List<Plugin> getPluginList(Map<String, Object> paramMap) {
        return pluginMapper.getPluginList(paramMap);
    }
}
