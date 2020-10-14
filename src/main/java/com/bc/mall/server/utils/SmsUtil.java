package com.bc.mall.server.utils;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.SmsConfig;
import com.bc.mall.server.entity.SmsTemplate;
import com.bc.mall.server.entity.TemplateParam;


/**
 * 短信工具类(阿里云)
 *
 * @author zhou
 */
public class SmsUtil {
    public static void sendSms(SmsConfig smsConfig, SmsTemplate smsTemplate, TemplateParam templateParam, String phoneNumbers) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", smsConfig.getAccessKeyId(), smsConfig.getAccessSecret());
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumbers);
        request.putQueryParameter("SignName", smsTemplate.getSignName());
        request.putQueryParameter("TemplateCode", smsTemplate.getTemplateCode());
        request.putQueryParameter("TemplateParam", JSON.toJSONString(templateParam));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public static TemplateParam getTemplateParam(int templateCategory, String code) {
        TemplateParam templateParam = new TemplateParam();
        switch (templateCategory) {
            // 登录
            case Constant.SMS_TEMPLATE_CATEGORY_LOGIN:
                templateParam.setCode(code);
                break;
            default:
                break;
        }
        return templateParam;
    }
}
