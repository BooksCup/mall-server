package com.bc.mall.server.service;

import com.bc.mall.server.entity.SmsConfig;
import com.bc.mall.server.entity.SmsTemplate;

import java.util.Map;

public interface SmsService {
    SmsConfig getSmsConfig(String storeId);

    SmsTemplate getSmsTemplateByParam(Map<String, Object> paramMap);
}
