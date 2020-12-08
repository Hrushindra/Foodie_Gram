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
@RequestMapping(value="/foodie_gram")
public class LoginController {
	
	@Autowired
	LoginServices loginServices;
	
	@RequestMapping(value="/")
	public String home() {
		return "redirect:/home.jsp";
	}
	
	@RequestMapping(value="/signup")
	public ModelAndView signUp(ModelAndView modelAndView,@RequestParam("userName") String userName,@RequestParam("userEmail") String userEmail,@RequestParam("contactNumber") String contactNumber,@RequestParam("userPassword") String userPassword,@RequestParam("userBirthDate") Date userBirthDate,@RequestParam("state")String state,@RequestParam("city")String city) {
		
		UserBean userBean=new UserBean();
		userBean.setUserName(userName);
		userBean.setUserEmail(userEmail);
		userBean.setContactNumber(contactNumber);
		userBean.setUserPassword(userPassword);
		userBean.setUserBirthDate(userBirthDate);
		userBean.setState(state);
		userBean.setCity(city);
		userBean=loginServices.newUser(userBean);
		modelAndView.addObject("userBean", userBean);
		modelAndView.setViewName("redirect:/foodie_gram.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView logIn(ModelAndView modelAndView,@RequestParam("userEmail")String userEmail,@RequestParam("userPassword")String userPassword) {
		UserBean userBean=new UserBean();
		userBean.setUserEmail(userEmail);
		userBean.setUserPassword(userPassword);
		boolean userValidation=loginServices.userLogin(userBean);
		
		return modelAndView;
	}
	
}
