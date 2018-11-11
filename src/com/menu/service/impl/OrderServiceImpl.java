package com.menu.service.impl;

import com.menu.mapper.OrderMapper;
import com.menu.pojo.Orders;
import com.menu.pojo.User;
import com.menu.service.OrderService;
import com.menu.service.VagetableService;
import com.menu.utils.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private VagetableService vagetableService;

    @Override
    public List<Orders> oredrList(User user) {
        return orderMapper.orderList(user);
    }

    @Override
    public void addOrder(OrderVo orderVo) {
        // 补全属性
        orderVo.setOrderId(UUID.randomUUID().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String date = sdf.format(new Date());
        orderVo.setOrderCreatedTime(date);
        orderVo.setOrderFlag(1);
        orderVo.setOrderDelete(1);
        // 上面的属性都补全了，还差price属性，需要查询所有的菜品，把价格加起来

        Double price = vagetableService.priceSum(orderVo);
        orderVo.setOrderPrice(price);

        // 插入订单表
        orderMapper.addOrder(orderVo);
        
        // 插入订单-菜品表
        for (String id : orderVo.getIds()) {
            orderMapper.addOrderVage(orderVo.getOrderId(), id);
        }

    }

    @Override
    public void deleteOrder(String orderId) {
        orderMapper.deleteOrder(orderId);
    }

    @Override
    public void buy(String orderId) {
        orderMapper.buy(orderId);
    }

}
