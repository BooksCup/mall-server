package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.SmsConfig;
import com.bc.mall.server.entity.SmsTemplate;

import java.util.List;
import java.util.Map;

/**
 * 短信
 *
 * @author zhou
 */
public interface SmsMapper {
    SmsConfig getSmsConfig(String storeId);

    List<SmsTemplate> getSmsTemplateListByParam(Map<String,Object> paramMap);
}
