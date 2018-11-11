package com.menu.mapper;


import com.menu.pojo.Desk;
import com.menu.pojo.Room;

import java.util.List;

public interface DeskMapper {

    // 获取餐桌列表
    List<Desk> deskList();

    // 新增餐桌
    void addDesk(Desk desk);

    // 删除餐桌
    void deleteDeskById(String deskId);

    // 根据id获取餐桌
    Desk getDeskById(String deskId);

    // 编辑餐桌
    void editDesk(Desk desk);

    // 根据房间号获取餐桌
    List<Desk> getDeskListByRoom(Room room);
}
