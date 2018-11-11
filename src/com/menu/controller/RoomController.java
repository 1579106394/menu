package com.menu.controller;

import com.menu.pojo.Room;
import com.menu.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * 新增用餐房间
     * @param room
     * @return
     */
    @RequestMapping("room/addRoom.html")
    public String addRoom(Room room) {

        roomService.addRoom(room);

        return "redirect:/room/roomList.html";
    }

    /**
     * 房间列表
     * @param model
     * @return
     */
    @RequestMapping("room/roomList.html")
    public String roomList(Model model) {

        List<Room> roomList = roomService.roomList();

        model.addAttribute("roomList", roomList);

        return "jsp/room/list";
    }

    /**
     * 删除用餐房间
     * @param roomId
     * @return
     */
    @RequestMapping("room/deleteRoom{roomId}.html")
    public String deleteRoom(@PathVariable String roomId) {

        roomService.deleteRoomById(roomId);

        return "redirect:/room/roomList.html";
    }

    /**
     * 查询房间信息，跳转到用餐房间回显
     * @param roomId
     * @param model
     * @return
     */
    @RequestMapping("room/toEdit{roomId}.html")
    public String toEdit(@PathVariable String roomId, Model model) {

        Room room = roomService.getRoomById(roomId);

        model.addAttribute("room", room);

        return "jsp/room/edit";
    }

    /**
     * 编辑用餐房间
     * @param room
     * @return
     */
    @RequestMapping("room/editRoom.html")
    public String editRoom(Room room) {

        roomService.editRoom(room);

        return "redirect:/room/roomList.html";
    }


}
