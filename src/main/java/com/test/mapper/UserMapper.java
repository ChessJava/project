package com.test.mapper;

import com.test.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

	@Select({
		"select id,username,password",
		"from user",
		"where username = #{username,jdbcType=VARCHAR}",
		"and password = #{password,jdbcType=VARCHAR}"
	})
    User findUser(String username, String password);

	@Select({
		"select id,username,password",
		"from user"
	})
	List<User> findAll();
}
