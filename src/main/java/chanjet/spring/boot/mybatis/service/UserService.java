package chanjet.spring.boot.mybatis.service;

import chanjet.spring.boot.mybatis.entity.User;

public interface UserService {
	public User getUserByName(String name);
}
