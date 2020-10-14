package com.bc.mall.server.mapper;

import com.bc.mall.server.entity.SmsConfig;
import com.bc.mall.server.entity.SmsTemplate;
import com.bc.mall.server.entity.VerifyCode;

import java.util.List;
import java.util.Map;

/**
 * 短信
 *
 * @author zhou
 */
public interface SmsMapper {
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
    List<SmsTemplate> getSmsTemplateListByParam(Map<String, Object> paramMap);

    /**
     * 保存验证码
     *
     * @param verifyCode 验证码
     */
    void addVerifyCode(VerifyCode verifyCode);
}
