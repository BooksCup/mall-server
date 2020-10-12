package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.StoreConfig;
import com.bc.mall.server.entity.User;
import com.bc.mall.server.enums.ResponseMsg;
import com.bc.mall.server.service.StoreConfigService;
import com.bc.mall.server.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
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

    @Resource
    private StoreConfigService storeConfigService;

    @Resource
    private UserService userService;

    @ApiOperation(value = "注册", notes = "注册")
    @PostMapping(value = "")
    public ResponseEntity<User> register(
            @RequestParam String storeId,
            @RequestParam String storeType,
            @RequestParam String userName,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String verificationCode) {
        logger.info("[register] storeId: " + storeId + ", storeType: " + storeType + ", userName: " + userName
                + ", phone: " + phone + ", verificationCode: " + verificationCode);
        ResponseEntity<User> responseEntity;
        try {
            // 账号已被注册
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("userName", userName);
            paramMap.put("storeId", storeId);
            if (userService.checkUserNameExist(paramMap)) {
                User user = new User();
                user.setResponseCode(ResponseMsg.USER_NAME_EXISTS.getResponseCode());
                user.setResponseMessage(ResponseMsg.USER_NAME_EXISTS.getResponseMessage());
                return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
            }

            // 手机号已被注册
            paramMap.clear();
            paramMap.put("phone", phone);
            paramMap.put("storeId", storeId);
            if (userService.checkPhoneExist(paramMap)) {
                User user = new User();
                user.setResponseCode(ResponseMsg.USER_PHONE_EXISTS.getResponseCode());
                user.setResponseMessage(ResponseMsg.USER_PHONE_EXISTS.getResponseMessage());
                return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
            }

            // 验证验证码

            // 获取默认用户名和用户头像(店铺)
            StoreConfig storeConfig = storeConfigService.getStoreConfigByStoreId(storeId);

            // 获取token

            // 注册
            User user = new User(storeId, userName, phone, storeConfig.getWxDefaultAvatar(), password, storeType);
            userService.addUser(user);

            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[register] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
