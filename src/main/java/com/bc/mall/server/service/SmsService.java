package com.bc.mall.server.service;

import com.bc.mall.server.entity.SmsConfig;
import com.bc.mall.server.entity.SmsTemplate;

import java.util.Map;

/**
 * 短信
 *
 * @author zhou
 */
public interface SmsService {
    /**
     * 获取短信配置
     *
     * @param storeId 店铺ID
     * @return 短信配置
     */
    SmsConfig getSmsConfig(String storeId);

    /**
     * 获取短信模板
     *
     * @param paramMap 参数map
     * @return 短信模板
     */
    SmsTemplate getSmsTemplateByParam(Map<String, Object> paramMap);
}
