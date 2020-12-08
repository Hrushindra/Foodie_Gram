package com.services.login;

import com.bean.user.UserBean;

public interface LoginServices {
	public UserBean newUser(UserBean userBean);
	public UserBean userLogin(UserBean userBean);
}
