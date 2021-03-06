package com.bc.mall.server.service;

import com.bc.mall.server.entity.Plugin;

import java.util.List;
import java.util.Map;

/**
 * 插件
 *
 * @author zhou
 */
public interface PluginService {

    /**
     * 获取插件列表
     *
     * @param paramMap 参数map
     * @return 插件列表
     */
    List<Plugin> getPluginList(Map<String, Object> paramMap);
}
