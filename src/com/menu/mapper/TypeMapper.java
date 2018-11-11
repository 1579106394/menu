package com.menu.mapper;

import com.menu.pojo.Type;

import java.util.List;


public interface TypeMapper {

	List<Type> getTypeList();

	void deleteTypeById(String typeId);

	Type getType(Type type);

	void editType(Type type);

	void addType(Type type);

	Integer getTypeCount(Type type);
}
