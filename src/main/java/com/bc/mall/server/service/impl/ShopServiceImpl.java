package com.bc.mall.server.service.impl;

import com.bc.mall.server.entity.Shop;
import com.bc.mall.server.mapper.ShopMapper;
import com.bc.mall.server.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 店铺
 *
 * @author zhou
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopMapper shopMapper;

    /**
     * 根据店铺ID查询店铺
     *
     * @param paramMap 参数map
     * @return 店铺
     */
    @Override
    public Shop getShopByShopId(Map<String, String> paramMap) {
        List<Shop> shopList = shopMapper.getShopListByShopId(paramMap);
        if (!CollectionUtils.isEmpty(shopList)) {
            return shopList.get(0);
        }
        return null;
    }
}
