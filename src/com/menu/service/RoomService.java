package com.menu.service;

import com.menu.pojo.Room;

import java.util.List;

public interface RoomService {

    // 新增用餐房间
    void addRoom(Room room);

    // 用餐房间列表
    List<Room> roomList();

    // 删除用餐房间
    void deleteRoomById(String roomId);

    // 获取用餐房间
    Room getRoomById(String roomId);

    // 编辑房间
    void editRoom(Room room);
}
