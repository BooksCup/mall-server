package com.bc.mall.server.service;

import com.bc.mall.server.entity.SmsConfig;
import com.bc.mall.server.entity.SmsTemplate;
import com.bc.mall.server.entity.VerifyCode;

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

    /**
     * 保存验证码
     *
     * @param verifyCode 验证码
     */
    void addVerifyCode(VerifyCode verifyCode);

    /**
     * 获取验证码
     *
     * @param paramMap 参数map,包含手机号(phone)和验证码类别(category)
     * @return 验证码
     */
    VerifyCode getVerifyCodeByParam(Map<String, Object> paramMap);
}
