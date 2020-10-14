package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.SmsConfig;
import com.bc.mall.server.entity.SmsTemplate;
import com.bc.mall.server.mapper.SmsMapper;
import com.bc.mall.server.service.SmsService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 短信
 *
 * @author zhou
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {
    @Resource
    private SmsMapper smsMapper;

    public SmsConfig getSmsConfig(String storeId) {
        return smsMapper.getSmsConfig(storeId);
    }

    public SmsTemplate getSmsTemplateByParam(Map<String, Object> paramMap) {
        List<SmsTemplate> smsTemplateList = smsMapper.getSmsTemplateListByParam(paramMap);
        if (!CollectionUtils.isEmpty(smsTemplateList)) {
            return smsTemplateList.get(0);
        }
        return null;
    }
}
