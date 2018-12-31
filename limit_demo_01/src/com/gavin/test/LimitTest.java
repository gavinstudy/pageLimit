package com.gavin.test;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.gavin.entity.User;
import com.gavin.service.UserService;

class LimitTest {
	private static UserService userService;
	public static void main(String args[]) {
		userService = new  UserService();
		List<User> list = userService.getListUser();
		for (User user : list) {
			System.out.println(user);
		}
	}

}
