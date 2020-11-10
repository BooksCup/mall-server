package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.StoreConfig;
import com.bc.mall.server.entity.User;
import com.bc.mall.server.entity.VerifyCode;
import com.bc.mall.server.enums.ResponseMsg;
import com.bc.mall.server.service.SmsService;
import com.bc.mall.server.service.StoreConfigService;
import com.bc.mall.server.service.TokenService;
import com.bc.mall.server.service.UserService;
import com.bc.mall.server.utils.WechatUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource
    private SmsService smsService;

    @ApiOperation(value = "注册", notes = "注册")
    @PostMapping(value = "")
    public ResponseEntity<User> register(
            @RequestParam String storeId,
            @RequestParam String storeType,
            @RequestParam String userName,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String verifyCode) {
        logger.info("[register] storeId: " + storeId + ", storeType: " + storeType + ", userName: " + userName
                + ", phone: " + phone + ", verifyCode: " + verifyCode);
        ResponseEntity<User> responseEntity;
        try {
            // 账号已被注册
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("userName", userName);
            paramMap.put("storeId", storeId);
            if (userService.checkUserNameExist(paramMap)) {
                return new ResponseEntity<>(
                        new User(ResponseMsg.USER_NAME_EXISTS.getResponseCode(),
                                ResponseMsg.USER_NAME_EXISTS.getResponseMessage()),
                        HttpStatus.BAD_REQUEST);
            }

            // 手机号已被注册
            paramMap.clear();
            paramMap.put("phone", phone);
            paramMap.put("storeId", storeId);
            if (userService.checkPhoneExist(paramMap)) {
                return new ResponseEntity<>(
                        new User(ResponseMsg.USER_PHONE_EXISTS.getResponseCode(),
                                ResponseMsg.USER_PHONE_EXISTS.getResponseMessage()),
                        HttpStatus.BAD_REQUEST);
            }

            // 验证验证码
            paramMap.clear();
            paramMap.put("phone", phone);
            paramMap.put("category", Constant.SMS_TEMPLATE_CATEGORY_REGISTER);
            VerifyCode code = smsService.getVerifyCodeByParam(paramMap);
            if (null == code || !code.getCode().equals(verifyCode)) {
                return new ResponseEntity<>(
                        new User(ResponseMsg.VERIFY_CODE_NOT_CORRECT.getResponseCode(),
                                ResponseMsg.VERIFY_CODE_NOT_CORRECT.getResponseMessage()),
                        HttpStatus.BAD_REQUEST);
            }

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
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
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
            responseEntity = new ResponseEntity<>(
                    new User(ResponseMsg.LOGIN_ERROR.getResponseCode(),
                            ResponseMsg.LOGIN_ERROR.getResponseMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 通过验证码登录
     *
     * @param storeId    店铺ID
     * @param storeType  店铺类型
     * @param phone      手机号
     * @param verifyCode 验证码
     * @param token      token
     * @param clientId   客户端ID,推送用
     * @return ResponseEntity<User>
     */
    @ApiOperation(value = "通过验证码登录", notes = "通过验证码登录")
    @GetMapping(value = "/loginByCode")
    public ResponseEntity<User> loginByCode(
            @RequestParam String storeId,
            @RequestParam String storeType,
            @RequestParam String phone,
            @RequestParam String verifyCode,
            @RequestParam(required = false) String token,
            @RequestParam(required = false) String clientId) {
        logger.info("[loginByCode] storeId: " + storeId + ", phone: "
                + phone + ", verifyCode: " + verifyCode + ", token: " + token + ", clientId: " + clientId);
        ResponseEntity<User> responseEntity;
        User user;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            // 校验验证码
            paramMap.put("phone", phone);
            paramMap.put("category", Constant.SMS_TEMPLATE_CATEGORY_LOGIN);
            VerifyCode code = smsService.getVerifyCodeByParam(paramMap);
            if (null == code || !code.getCode().equals(verifyCode)) {
                return new ResponseEntity<>(
                        new User(ResponseMsg.VERIFY_CODE_NOT_CORRECT.getResponseCode(),
                                ResponseMsg.VERIFY_CODE_NOT_CORRECT.getResponseMessage()),
                        HttpStatus.BAD_REQUEST);
            }

            // 获取token
            token = getToken(token);

            paramMap.clear();
            paramMap.put("storeId", storeId);
            paramMap.put("phone", phone);
            List<User> userList = userService.getUserListByPhone(paramMap);
            if (CollectionUtils.isEmpty(userList)) {
                // 用户不存在
                // 获取默认用户名和用户头像(店铺)
                StoreConfig storeConfig = storeConfigService.getStoreConfigByStoreId(storeId);

                // 注册
                user = new User(storeId, storeConfig.getWxDefaultName(), phone, storeConfig.getWxDefaultAvatar(), "", storeType);
                user.setToken(token);
                userService.addUser(user);
            } else {
                //用户存在
                user = userList.get(0);
                if (StringUtils.isEmpty(user.getPassword())) {
                    user.setHasPassword(Constant.HAS_PASSWORD_NO);
                } else {
                    user.setHasPassword(Constant.HAS_PASSWORD_YES);
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
            responseEntity = new ResponseEntity<>(
                    new User(ResponseMsg.LOGIN_ERROR.getResponseCode(),
                            ResponseMsg.LOGIN_ERROR.getResponseMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    private String getToken(String token) {
        if (StringUtils.isEmpty(token)) {
            token = tokenService.getToken();
        } else {
            if (!tokenService.verifyToken(token)) {
                // token过期，验证token失败
                token = tokenService.getToken();
            }
        }
        return token;
    }

    /**
     * 绑定微信用户
     *
     * @param storeId   店铺ID
     * @param storeType 店铺类型
     * @param code      登录凭证
     * @param nickName  昵称
     * @param avatar    头像
     * @param sex       性别
     * @return ResponseEntity
     */
    @ApiOperation(value = "绑定微信用户", notes = "绑定微信用户")
    @PostMapping(value = "/bindWechatUser")
    public ResponseEntity<User> bindWechatUser(
            @RequestParam String storeId,
            @RequestParam String storeType,
            @RequestParam String code,
            @RequestParam String nickName,
            @RequestParam String avatar,
            @RequestParam String sex) {
        logger.info("[bindWechatUser] storeId: " + storeId + ", storeType: " + storeType + ", code: " + code
                + ", nickName: " + nickName + ", avatar: " + avatar + ", sex: " + sex);
        ResponseEntity<User> responseEntity;
        try {
            StoreConfig storeConfig = storeConfigService.getStoreConfigByStoreId(storeId);
            if (null == storeConfig) {
                return new ResponseEntity<>(
                        new User(ResponseMsg.STORE_CONFIG_EMPTY.getResponseCode(),
                                ResponseMsg.STORE_CONFIG_EMPTY.getResponseMessage()),
                        HttpStatus.BAD_REQUEST);
            }
            User wxUserInfo = WechatUtil.getWechatUserInfo(storeConfig.getAppId(), storeConfig.getAppSecret(), code);
            if (null == wxUserInfo) {
                return new ResponseEntity<>(
                        new User(ResponseMsg.STORE_CONFIG_NOT_CORRECT.getResponseCode(),
                                ResponseMsg.STORE_CONFIG_NOT_CORRECT.getResponseMessage()),
                        HttpStatus.BAD_REQUEST);
            }
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            paramMap.put("openid", wxUserInfo.getWxOpenid());
            User user = userService.getUserByOpenId(paramMap);
            if (null == user) {
                // 不存在,插入
                user = new User(storeId, nickName, avatar, sex, storeType);
                user.setWxOpenid(wxUserInfo.getWxOpenid());
                userService.addUserByWechatAuth(user);
            } else {
                // 存在,修改
                user.setUserName(nickName);
                user.setAvatar(avatar);
                user.setSex(sex);
                userService.updateUserByWechatAuth(user);
            }
            user.setResponseCode(ResponseMsg.BIND_WECHAT_USER_SUCCESS.getResponseCode());
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[bindWechatUser] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
