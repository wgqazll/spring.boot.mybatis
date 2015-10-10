package chanjet.spring.boot.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chanjet.spring.boot.mybatis.entity.User;
import chanjet.spring.boot.mybatis.mapper.UserMapper;
import chanjet.spring.boot.mybatis.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUserByName(String name){
		User user = userMapper.getUserByName(name);
		return user;
	}
}
