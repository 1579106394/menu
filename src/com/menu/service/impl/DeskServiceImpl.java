package com.menu.service.impl;

import com.menu.mapper.DeskMapper;
import com.menu.pojo.Desk;
import com.menu.pojo.Room;
import com.menu.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DeskServiceImpl implements DeskService {

    @Autowired
    private DeskMapper deskMapper;

    @Override
    public List<Desk> deskList() {
        return deskMapper.deskList();
    }

    @Override
    public void addDesk(Desk desk) {
        // 补全属性
        desk.setDeskId(UUID.randomUUID().toString());
        deskMapper.addDesk(desk);
    }

    @Override
    public void deleteDeskById(String deskId) {
        deskMapper.deleteDeskById(deskId);
    }

    @Override
    public Desk getDeskById(String deskId) {
        return deskMapper.getDeskById(deskId);
    }

    @Override
    public void editDesk(Desk desk) {
        deskMapper.editDesk(desk);
    }

    @Override
    public List<Desk> getDeskListByRoom(Room room) {
        return deskMapper.getDeskListByRoom(room);
    }

}
