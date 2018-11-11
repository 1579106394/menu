package com.menu.controller;

import com.menu.pojo.Orders;
import com.menu.pojo.Room;
import com.menu.pojo.User;
import com.menu.pojo.Vagetable;
import com.menu.service.OrderService;
import com.menu.service.RoomService;
import com.menu.service.VagetableService;
import com.menu.utils.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private VagetableService vagetableService;

    /**
     * 获取订单列表
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("order/orderList.html")
    public String orderList(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Orders> orderList = orderService.oredrList(user);

        model.addAttribute("orderList", orderList);

        return "jsp/order/list";
    }

    /**
     * 查询菜品和房间信息，跳转到点餐页面并回显
     * @param model
     * @return
     */
    @RequestMapping("order/toOrder.html")
    public String toAdd(Model model) {

        // 查询所有房间信息，发送到页面上
        List<Room> roomList = roomService.roomList();
        // 查询到所有菜品信息，发送到页面上
        Vagetable vagetable = new Vagetable();
        List<Vagetable> vageList = vagetableService.getVageList(vagetable);

        model.addAttribute("roomList", roomList);
        model.addAttribute("vageList", vageList);

        return "jsp/order/add";
    }

    /**
     * 点餐
     * @param orderVo
     * @param session
     * @return
     */
    @RequestMapping("order/addOrder.html")
    public String addOrder(OrderVo orderVo, HttpSession session) {

        User user = (User) session.getAttribute("user");

        orderVo.setUser(user);

        orderService.addOrder(orderVo);

        return "redirect:/order/orderList.html";
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @RequestMapping("order/deleteOrder{orderId}.html")
    public String deleteOrder(@PathVariable String orderId) {

        orderService.deleteOrder(orderId);

        return "redirect:/order/orderList.html";
    }

    /**
     * 买单
     * @param orderId
     * @return
     */
    @RequestMapping("order/buy{orderId}.html")
    public String buy(@PathVariable String orderId) {
        orderService.buy(orderId);

        return "redirect:/order/orderList.html";
    }

    @RequestMapping("order/orderInfo{orderId}.html")
    public String orderInfo(Model model, @PathVariable String orderId) {

        List<Vagetable> vageList = vagetableService.getVageListByOrder(orderId);
        model.addAttribute("vageList", vageList);

        return "jsp/order/info";
    }


}
