package com.menu.mapper;


import com.menu.pojo.Orders;
import com.menu.pojo.User;
import com.menu.utils.OrderVo;

import java.util.List;

public interface OrderMapper {

    // 获取订单列表
    List<Orders> orderList(User user);

    // 下单订餐
    void addOrder(OrderVo orderVo);

    // 查询订单-菜品对应表
    void addOrderVage(String orderId, String id);

    // 删除订单
    void deleteOrder(String orderId);

    // 买单
    void buy(String orderId);
}
