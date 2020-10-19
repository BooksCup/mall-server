package com.bc.mall.server.controller;


import com.bc.mall.server.entity.*;
import com.bc.mall.server.enums.ResponseMsg;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 导航
 *
 * @author zhou
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @ApiOperation(value = "获取个人信息", notes = "获取个人信息")
    @GetMapping(value = "/me")
    public ResponseEntity<MyProfile> getMyProfile(@RequestParam String storeId,
                                                  @RequestParam String storeType,
                                                  @RequestParam String token) {
        logger.info("[getMyProfile] storeId: " + storeId + ", storeType: " + storeType +
                ", token: " + token);
        ResponseEntity<MyProfile> responseEntity;
        try {
            if (StringUtils.isEmpty(token)) {
                return new ResponseEntity<>(
                        new MyProfile(ResponseMsg.NOT_LOGIN.getResponseCode(), ResponseMsg.NOT_LOGIN.getResponseMessage()),
                        HttpStatus.BAD_REQUEST);
            } else {

            }
            responseEntity = new ResponseEntity<>(new MyProfile(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getMyProfile] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new MyProfile(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
