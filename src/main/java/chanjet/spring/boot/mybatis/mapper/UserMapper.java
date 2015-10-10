package chanjet.spring.boot.mybatis.mapper;

import chanjet.spring.boot.mybatis.entity.User;

public interface UserMapper {
	public User getUserByName(String name);
}
