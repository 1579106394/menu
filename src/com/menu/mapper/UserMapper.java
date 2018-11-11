package com.menu.mapper;


import com.menu.pojo.User;

public interface UserMapper {

	User getUserByUsername(User user);

	void insertUser(User user);
}
