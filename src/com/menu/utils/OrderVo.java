package com.menu.utils;

import com.menu.pojo.Orders;
import com.menu.pojo.Room;

import java.io.Serializable;

public class OrderVo extends Orders implements Serializable {

    private String[] ids;

    private Room room;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
