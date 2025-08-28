package com.excelsoft.service;

import com.excelsoft.enties.User;

public interface UserService {
	User registerNewUserService(User user);
	User SearchByUserName(String userName);

}
