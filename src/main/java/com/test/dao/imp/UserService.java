package com.test.dao.imp;

import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements UserDao {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User findUser(String username, String password) {
		User user = userMapper.findUser(username,password);
		if(user != null) {
			return user;
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> list = userMapper.findAll();
		if(list != null){
			return list;
		}
		return null;
	}


}
