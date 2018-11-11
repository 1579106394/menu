package com.menu.service.impl;

import com.menu.mapper.TypeMapper;
import com.menu.pojo.Type;
import com.menu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    public List<Type> getTypeList() {
        return typeMapper.getTypeList();
    }

    public void deleteTypeById(String typeId) {
        typeMapper.deleteTypeById(typeId);
    }

    public Type getType(Type type) {
        return typeMapper.getType(type);
    }

    public void editType(Type type) {
        typeMapper.editType(type);
    }

    public void addType(Type type) {
        type.setTypeId(UUID.randomUUID().toString());
        type.setTypeNum(0);
        typeMapper.addType(type);
    }

    public Integer getTypeCount(Type type) {
        return typeMapper.getTypeCount(type);
    }
}
