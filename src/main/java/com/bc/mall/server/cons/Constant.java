package com.bc.mall.server.cons;


/**
 * 常量类
 *
 * @author zhou
 */
public class Constant {

    /**
     * 初始化hashmap容量
     */
    public static final int DEFAULT_HASH_MAP_CAPACITY = 16;

    /**
     * 无密码
     */
    public static final String HAS_PASSWORD_NO = "0";

    /**
     * 有密码
     */
    public static final String HAS_PASSWORD_YES = "1";

    /**
     * 删除状态 - “未删除”
     */
    public static final String DELETE_STATUS_NOT = "0";

    /**
     * 第一级父ID
     */
    public static final String FIRST_CLASS_PARENT_ID = "0";

    // 短信模板类别
    /**
     * 注册
     */
    public static final int SMS_TEMPLATE_CATEGORY_REGISTER = 0;

    /**
     * 登录
     */
    public static final int SMS_TEMPLATE_CATEGORY_LOGIN = 1;

    /**
     * 插件关闭
     */
    public static final String PLUGIN_DISABLED = "0";

    /**
     * 插件开启
     */
    public static final String PLUGIN_ENABLED = "1";

    /**
     * 插件显示在首页
     */
    public static final String PLUGIN_SHOW = "1";

    /**
     * 插件编码-"竞拍"
     */
    public static final String PLUGIN_CODE_AUCTION = "auction";

    /**
     * 插件编码-"分销"
     */
    public static final String PLUGIN_CODE_DISTRIBUTOR = "distributor";

    /**
     * 插件编码-"积分商城"
     */
    public static final String PLUGIN_CODE_INTEGRAL = "integral";

    /**
     * 插件编码-"砍价"
     */
    public static final String PLUGIN_CODE_BARGAIN = "bargain";

    /**
     * 插件编码-"拼团"
     */
    public static final String PLUGIN_CODE_GROUP = "group";

    /**
     * 插件编码-"秒杀"
     */
    public static final String PLUGIN_CODE_SECKILL = "seckill";

    /**
     * 是否被收藏-"是"
     */
    public static final String IS_COLLECTED_YES = "1";

    /**
     * 是否被收藏-"否"
     */
    public static final String IS_COLLECTED_NO = "0";
}
