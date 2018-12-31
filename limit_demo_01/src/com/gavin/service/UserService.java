package com.gavin.service;

import java.util.List;

import com.gavin.dao.UserDao;
import com.gavin.entity.User;

public class UserService {
	private UserDao userDao;
	public UserService() {
		userDao = new UserDao();
	}
	public List<User> getListUser(){
		List<User> list = userDao.selectList();
		return list;
	}
}
