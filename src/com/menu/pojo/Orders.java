package com.menu.pojo;

import java.io.Serializable;
import java.util.*;

/**
 * CREATE TABLE `orders` (
 *   `order_id` varchar(36) NOT NULL,
 *   `order_user_id` varchar(36) NOT NULL,
 *   `order_price` double NOT NULL DEFAULT '0',
 *   `order_desk` varchar(36) NOT NULL COMMENT '这个订单在多少号桌',
 *   `order_created_time` varchar(50) NOT NULL COMMENT '创建时间',
 *   `order_flag` int(11) NOT NULL DEFAULT '1' COMMENT '1没买单，2买单',
 *   `order_delete` int(2) NOT NULL DEFAULT '1' COMMENT '1正常2删除',
 *   PRIMARY KEY (`order_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Orders implements Serializable {

    private String orderId;
    private User user;
    private Desk desk;
    private List<Vagetable> flowerList = new ArrayList<Vagetable>();
    private String orderCreatedTime;
    private Integer orderDelete;
    private Double orderPrice;
    private Integer orderFlag;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public List<Vagetable> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<Vagetable> flowerList) {
        this.flowerList = flowerList;
    }

    public String getOrderCreatedTime() {
        return orderCreatedTime;
    }

    public void setOrderCreatedTime(String orderCreatedTime) {
        this.orderCreatedTime = orderCreatedTime;
    }

    public Integer getOrderDelete() {
        return orderDelete;
    }

    public void setOrderDelete(Integer orderDelete) {
        this.orderDelete = orderDelete;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
    }
}
