package com.menu.service;

import com.menu.pojo.Orders;
import com.menu.pojo.User;
import com.menu.utils.OrderVo;

import java.util.List;

public interface OrderService {

    // 获取点餐列表
    List<Orders> oredrList(User user);

    // 下单
    void addOrder(OrderVo orderVo);

    // 删除订单
    void deleteOrder(String orderId);

    // 买单
    void buy(String orderId);
}
