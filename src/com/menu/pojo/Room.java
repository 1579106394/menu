package com.menu.pojo;

import java.io.Serializable;

/**
 * CREATE TABLE `room` (
 *   `room_id` varchar(36) NOT NULL,
 *   `room_name` varchar(36) NOT NULL COMMENT '房间名称，xx房',
 *   PRIMARY KEY (`room_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Room implements Serializable {

    private String roomId;
    private String roomName;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
