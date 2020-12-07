package com.controller.login;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bean.user.UserBean;
import com.services.login.LoginServices;

@RestController
public class LoginController {
	
	@Autowired
	LoginServices loginServices;
	
	@RequestMapping()
	public String signUp(ModelAndView modelAndView,@RequestParam("userName") String userName,@RequestParam("userEmail") String userEmail,@RequestParam("contactNumber") String contactNumber,@RequestParam("userPassword") String userPassword,@RequestParam("userBirthDate") Date userBirthDate,@RequestParam("state")String state,@RequestParam("city")String city) {
		
		UserBean userBean=new UserBean();
		userBean.setUserName(userName);
		userBean.setUserEmail(userEmail);
		userBean.setContactNumber(contactNumber);
		userBean.setUserPassword(userPassword);
		userBean.setUserBirthDate(userBirthDate);
		userBean.setState(state);
		userBean.setCity(city);
		loginServices.newUser(userBean);
		return "";
	}
}
