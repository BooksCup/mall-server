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

    /**
     * 店铺tab-"推荐"
     */
    public static final String SHOP_TAB_RECOMMEND = "1";

    /**
     * 店铺tab-"所有商品"
     */
    public static final String SHOP_TAB_ALL_GOODS = "2";

    /**
     * 店铺tab-"商品分类"
     */
    public static final String SHOP_TAB_GOODS_CLASS = "3";

    /**
     * 不允许购买
     */
    public static final String NOT_ALLOW_TO_BUY = "0";

    /**
     * 允许购买
     */
    public static final String ALLOW_TO_BUY = "1";

    // sku key
    /**
     * ID
     */
    public static final String SKU_KEY_ID = "skuId";

    /**
     * 库存
     */
    public static final String SKU_KEY_STOCK = "stock";

    /**
     * 价格
     */
    public static final String SKU_KEY_PRICE = "price";

    /**
     * 图片
     */
    public static final String SKU_KEY_IMAGE = "image";

    // 商品状态
    /**
     * 待上架
     */
    public static final String GOODS_STATUS_WAIT_SHELVE = "1";

    /**
     * 上架
     */
    public static final String GOODS_STATUS_SHELVE = "2";

    /**
     * 下架
     */
    public static final String GOODS_STATUS_OFF_SHELVE = "3";

    // 收藏类型
    /**
     * 商品
     */
    public static final String USER_COLLECTION_TYPE_GOODS = "0";

    /**
     * 店铺
     */
    public static final String USER_COLLECTION_TYPE_SHOP = "1";
}
