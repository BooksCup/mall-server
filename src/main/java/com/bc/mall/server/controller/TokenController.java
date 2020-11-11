package com.bc.mall.server.controller;

import com.bc.mall.server.cons.Constant;
import com.bc.mall.server.entity.User;
import com.bc.mall.server.enums.ResponseMsg;
import com.bc.mall.server.service.TokenService;
import com.bc.mall.server.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * token
 *
 * @author zhou
 */
@RestController
@RequestMapping("/token")
public class TokenController {

    private static final Logger logger = LoggerFactory.getLogger(TokenController.class);

    @Resource
    private UserService userService;

    @Resource
    private TokenService tokenService;

    /**
     * 检查token
     *
     * @param storeId   店铺ID
     * @param storeType 店铺类型
     * @param openid    openid
     * @return ResponseEntity
     */
    @ApiOperation(value = "检查token", notes = "检查token")
    @PostMapping(value = "/checkToken")
    public ResponseEntity<User> checkToken(
            @RequestParam String storeId,
            @RequestParam String storeType,
            @RequestParam String openid) {
        logger.info("[checkToken] storeId: " + storeId + ", storeType: "
                + storeType + ", openid: " + openid);
        ResponseEntity<User> responseEntity;
        User user;
        try {
            if (StringUtils.isEmpty(openid)) {
                return new ResponseEntity<>(
                        new User(ResponseMsg.OPEN_ID_EMPTY.getResponseCode(),
                                ResponseMsg.OPEN_ID_EMPTY.getResponseMessage()),
                        HttpStatus.BAD_REQUEST);
            }

            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            paramMap.put("openid", openid);

            user = userService.getUserByOpenId(paramMap);
            if (null == user) {
                return new ResponseEntity<>(
                        new User(ResponseMsg.USER_NOT_REGISTER.getResponseCode(),
                                ResponseMsg.USER_NOT_REGISTER.getResponseMessage()),
                        HttpStatus.BAD_REQUEST);
            } else {
                String token = user.getToken();
                if (StringUtils.isEmpty(token) || !tokenService.verifyToken(token)) {
                    token = tokenService.getToken();
                    user.setToken(token);
                    userService.updateUserToken(user);
                }
            }
            user.setResponseCode(ResponseMsg.CHECK_TOKEN_SUCCESS.getResponseCode());
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(
                    new User(ResponseMsg.SERVER_ERROR.getResponseCode(),
                            ResponseMsg.SERVER_ERROR.getResponseMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
