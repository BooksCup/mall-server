package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.GoodsClass;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "注册", notes = "注册")
    @PostMapping(value = "")
    public ResponseEntity<String> register(
            @RequestParam String storeId,
            @RequestParam String storeType,
            @RequestParam String userName,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String verificationCode) {
        logger.info("storeId: " + storeId + ", storeType: " + storeType + ", userName: " + userName
                + ", phone: " + phone + ", verificationCode: " + verificationCode);
        ResponseEntity<String> responseEntity;
        try {
            // 账号已被注册

            // 手机号已被注册

            // 验证验证码

            // 获取默认用户名和用户头像(店铺)

            // 获取token


            responseEntity = new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[register] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
