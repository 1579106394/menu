package com.menu.service.impl;

import com.menu.mapper.UserMapper;
import com.menu.pojo.User;
import com.menu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUserByUsername(User user) {
		return userMapper.getUserByUsername(user);
	}

	public void insertUser(User user) {
		userMapper.insertUser(user);
		
	}
}
