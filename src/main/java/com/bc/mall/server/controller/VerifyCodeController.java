package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.SmsConfig;
import com.bc.mall.server.entity.SmsTemplate;
import com.bc.mall.server.entity.TemplateParam;
import com.bc.mall.server.service.SmsService;
import com.bc.mall.server.utils.SmsUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 验证码
 *
 * @author zhou
 */
@RestController
@RequestMapping("/verifyCode")
public class VerifyCodeController {
    private static final Logger logger = LoggerFactory.getLogger(VerifyCodeController.class);

    @Resource
    private SmsService smsService;

    @ApiOperation(value = "发送验证码", notes = "发送验证码")
    @GetMapping(value = "")
    public ResponseEntity<String> getVerifyCode(@RequestParam String storeId,
                                                @RequestParam String phone,
                                                @RequestParam Integer templateType,
                                                @RequestParam Integer templateCategory) {
        logger.info("[getVerifyCode] storeId: " + storeId + ", phone: " + phone +
                ", templateType: " + templateType + ", templateCategory: " + templateCategory);
        ResponseEntity<String> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            paramMap.put("templateType", templateType);
            paramMap.put("templateCategory", templateCategory);

            SmsConfig smsConfig = smsService.getSmsConfig(storeId);
            SmsTemplate smsTemplate = smsService.getSmsTemplateByParam(paramMap);
            TemplateParam templateParam = SmsUtil.getTemplateParam(templateCategory, "213213");
            SmsUtil.sendSms(smsConfig, smsTemplate, templateParam, phone);

            responseEntity = new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getVerifyCode] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
