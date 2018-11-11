package com.menu.pojo;

import java.io.Serializable;

/**
 * CREATE TABLE `desk` (
 *   `desk_id` varchar(36) NOT NULL,
 *   `desk_name` int(11) NOT NULL COMMENT '几号桌',
 *   `desk_room` varchar(36) NOT NULL,
 *   `desk_num` int(11) NOT NULL DEFAULT '4' COMMENT '能坐多少人',
 *   PRIMARY KEY (`desk_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Desk implements Serializable {

    private String deskId;
    private Integer deskName;
    private Integer deskNum;
    private Room room;

    public String getDeskId() {
        return deskId;
    }

    public void setDeskId(String deskId) {
        this.deskId = deskId;
    }

    public Integer getDeskName() {
        return deskName;
    }

    public void setDeskName(Integer deskName) {
        this.deskName = deskName;
    }

    public Integer getDeskNum() {
        return deskNum;
    }

    public void setDeskNum(Integer deskNum) {
        this.deskNum = deskNum;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
