package com.dao.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.bean.user.UserBean;
import com.services.login.LoginServices;

@Repository
public class LoginDao implements LoginServices{
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public UserBean newUser(UserBean userBean) {
		
		return mongoTemplate.save(userBean);
	}
	
	
}
