package chanjet.spring.boot.mybatis.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chanjet.spring.boot.mybatis.entity.User;
import chanjet.spring.boot.mybatis.service.UserService;
import chanjet.spring.boot.mybatis.util.config.DataSourceConfig;


@RestController
public class UserController {
	
	private static Log logger = LogFactory.getLog(DataSourceConfig.class); 
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/getUser/{name}",method=RequestMethod.GET)
	public User getUserInfo(@PathVariable String name){
		User user = userService.getUserByName(name);
		logger.info("user info is" + user);
		return user;
	}
}