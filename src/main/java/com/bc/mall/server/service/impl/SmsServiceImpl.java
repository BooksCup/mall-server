package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.SmsConfig;
import com.bc.mall.server.entity.SmsTemplate;
import com.bc.mall.server.entity.VerifyCode;
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

    /**
     * 获取短信配置
     *
     * @param storeId 店铺ID
     * @return 短信配置
     */
    @Override
    public SmsConfig getSmsConfig(String storeId) {
        return smsMapper.getSmsConfig(storeId);
    }

    /**
     * 获取短信模板
     *
     * @param paramMap 参数map
     * @return 短信模板
     */
    @Override
    public SmsTemplate getSmsTemplateByParam(Map<String, Object> paramMap) {
        List<SmsTemplate> smsTemplateList = smsMapper.getSmsTemplateListByParam(paramMap);
        if (!CollectionUtils.isEmpty(smsTemplateList)) {
            return smsTemplateList.get(0);
        }
        return null;
    }

    /**
     * 保存验证码
     *
     * @param verifyCode 验证码
     */
    @Override
    public void addVerifyCode(VerifyCode verifyCode) {
        smsMapper.addVerifyCode(verifyCode);
    }

    /**
     * 获取验证码
     *
     * @param paramMap 参数map,包含手机号(phone)和验证码类别(category)
     * @return 验证码
     */
    @Override
    public VerifyCode getVerifyCodeByParam(Map<String, Object> paramMap) {
        List<VerifyCode> verifyCodeList = smsMapper.getVerifyCodeListByParam(paramMap);
        if (!CollectionUtils.isEmpty(verifyCodeList)) {
            return verifyCodeList.get(0);
        }
        return null;
    }
}
