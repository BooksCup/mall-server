package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.StoreConfig;
import com.bc.mall.server.entity.User;
import com.bc.mall.server.enums.ResponseMsg;
import com.bc.mall.server.service.StoreConfigService;
import com.bc.mall.server.service.TokenService;
import com.bc.mall.server.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.Response;
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

    @Resource
    private StoreConfigService storeConfigService;

    @Resource
    private UserService userService;

    @Resource
    private TokenService tokenService;

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

    /**
     * 通过账号密码登录
     *
     * @param storeId  店铺ID
     * @param account  账户
     * @param password 密码
     * @param token    token
     * @param clientId 客户端ID,推送用
     * @return ResponseEntity<User>
     */
    @ApiOperation(value = "通过账号密码登录", notes = "通过账号密码登录")
    @GetMapping(value = "/loginByPwd")
    public ResponseEntity<User> loginByPwd(
            @RequestParam String storeId,
            @RequestParam String account,
            @RequestParam String password,
            @RequestParam(required = false) String token,
            @RequestParam(required = false) String clientId) {
        logger.info("[loginByPwd] storeId: " + storeId + ", account: "
                + account + ", token: " + token + ", clientId: " + clientId);
        ResponseEntity<User> responseEntity;
        User user;
        try {
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("storeId", storeId);
            paramMap.put("account", account);
            List<User> userList = userService.getUserListByAccount(paramMap);
            if (CollectionUtils.isEmpty(userList)) {
                return new ResponseEntity<>(
                        new User(ResponseMsg.USER_NOT_REGISTER.getResponseCode(),
                                ResponseMsg.USER_NOT_REGISTER.getResponseMessage()),
                        HttpStatus.BAD_REQUEST);
            } else {
                user = userList.get(0);
                if (!password.equals(user.getPassword())) {
                    return new ResponseEntity<>(
                            new User(ResponseMsg.PASSWORD_NOT_CORRECT.getResponseCode(),
                                    ResponseMsg.PASSWORD_NOT_CORRECT.getResponseMessage()),
                            HttpStatus.BAD_REQUEST);
                }

                if (StringUtils.isEmpty(token)) {
                    token = tokenService.getToken();
                } else {
                    if (!tokenService.verifyToken(token)) {
                        // token过期，验证token失败
                        token = tokenService.getToken();
                    }
                }

                // 更新用户token和最后一次登录时间
                user.setToken(token);
                userService.updateUserByLogin(user);
            }
            user.setResponseCode(ResponseMsg.LOGIN_SUCCESS.getResponseCode());
            user.setResponseMessage(ResponseMsg.LOGIN_SUCCESS.getResponseMessage());
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
