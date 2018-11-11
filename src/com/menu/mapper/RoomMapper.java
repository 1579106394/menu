package com.menu.mapper;


import com.menu.pojo.Room;

import java.util.List;

public interface RoomMapper {

    // 新增用餐房间
    void addRoom(Room room);

    // 用餐房间列表
    List<Room> roomList();

    // 删除用餐房间
    void deleteRoomNById(String roomId);

    // 根据id获取用餐房间
    Room getRoomById(String roomId);

    // 编辑用餐房间
    void editRoom(Room room);
}
