package com.test.dao;

import com.test.entity.User;

import java.util.List;

public interface UserDao {

	User findUser(String username, String password);

	List<User> findAll();
}
