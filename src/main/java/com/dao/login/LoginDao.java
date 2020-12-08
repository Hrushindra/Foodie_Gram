package com.dao.login;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public UserBean userLogin(UserBean userBean) {
		List<UserBean> list=new ArrayList<UserBean>();
		list=mongoTemplate.findAll(UserBean.class);
		for(UserBean user:list) {
			if((user.getUserEmail().equals(userBean.getUserEmail())) && user.getUserPassword().equals(userBean.getUserPassword())) {
				return userBean;
			}
		}
		return userBean;
	}
	
	
}
