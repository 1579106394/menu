package com.menu.service;

import com.menu.pojo.Vagetable;
import com.menu.utils.OrderVo;

import java.util.List;

public interface VagetableService {

    // 获取菜品列表
    List<Vagetable> getVageList(Vagetable vage);

    // 添加菜品
    void addVage(Vagetable vage);

    // 删除菜品（逻辑删除）
    void deleteVage(String vageId);

    // 根据id获取菜品
    Vagetable getVageById(String vageId);

    // 编辑菜品
    void editVage(Vagetable vage);

    // 查询订单价格
    Double priceSum(OrderVo orderVo);

    // 获取订单中的菜品列表
    List<Vagetable> getVageListByOrder(String orderId);
}
