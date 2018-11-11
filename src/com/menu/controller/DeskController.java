package com.menu.controller;

import com.menu.pojo.Desk;
import com.menu.pojo.Room;
import com.menu.service.DeskService;
import com.menu.service.RoomService;
import com.menu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeskController {

    @Autowired
    private DeskService deskService;

    @Autowired
    private RoomService roomService;

    /**
     * 获取餐桌列表
     * @param model
     * @return
     */
    @RequestMapping("desk/deskList.html")
    public String deskList(Model model) {

        List<Desk> deskList = deskService.deskList();

        model.addAttribute("deskList", deskList);

        return "jsp/desk/list";
    }

    /**
     * 获取房间列表，跳转到新增餐桌页面
     * @param model
     * @return
     */
    @RequestMapping("desk/toAddDesk.html")
    public String toAddDesk(Model model) {

        List<Room> roomList = roomService.roomList();

        model.addAttribute("roomList", roomList);

        return "jsp/desk/add";
    }

    /**
     * 新增餐桌
     * @param desk
     * @return
     */
    @RequestMapping("desk/addDesk.html")
    public String addDesk(Desk desk) {

        deskService.addDesk(desk);

        return "redirect:/desk/deskList.html";
    }

    /**
     * 根据id删除餐桌
     * @param deskId
     * @return
     */
    @RequestMapping("desk/deleteDesk{deskId}.html")
    public String deleteDesk(@PathVariable String deskId) {

        deskService.deleteDeskById(deskId);

        return "redirect:/desk/deskList.html";
    }

    /**
     * 获取到餐桌属性，跳转到编辑界面回显
     * @param deskId
     * @param model
     * @return
     */
    @RequestMapping("desk/toEdit{deskId}.html")
    public String toEdit(@PathVariable String deskId, Model model) {

        Desk desk = deskService.getDeskById(deskId);
        List<Room> roomList = roomService.roomList();

        model.addAttribute("roomList", roomList);
        model.addAttribute("desk", desk);

        return "jsp/desk/edit";
    }

    /**
     * 编辑餐桌
     * @param desk
     * @return
     */
    @RequestMapping("desk/editDesk.html")
    public String editDesk(Desk desk) {

        deskService.editDesk(desk);

        return "redirect:/desk/deskList.html";
    }

    /**
     * ajax二级联动，加载餐桌
     * @param room
     * @return
     */
    @RequestMapping("desk/getDeskListByRoom.action")
    @ResponseBody
    public Result getDeskListByRoom(@RequestBody Room room) {

        List<Desk> deskList = deskService.getDeskListByRoom(room);

        return Result.ok(deskList);
    }

}
