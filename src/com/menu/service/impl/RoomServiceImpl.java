package com.menu.service.impl;

import com.menu.mapper.RoomMapper;
import com.menu.pojo.Room;
import com.menu.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public void addRoom(Room room) {
        // 补充属性
        room.setRoomId(UUID.randomUUID().toString());
        roomMapper.addRoom(room);
    }

    @Override
    public List<Room> roomList() {
        return roomMapper.roomList();
    }

    @Override
    public void deleteRoomById(String roomId) {
        roomMapper.deleteRoomNById(roomId);
    }

    @Override
    public Room getRoomById(String roomId) {
        return roomMapper.getRoomById(roomId);
    }

    @Override
    public void editRoom(Room room) {
        roomMapper.editRoom(room);
    }

}
