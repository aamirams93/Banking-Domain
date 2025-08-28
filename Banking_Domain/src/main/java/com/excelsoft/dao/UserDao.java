package com.excelsoft.dao;

import com.excelsoft.enties.User;

public interface UserDao {
	User registerNewUser(User user);

	User searchByUserName(String userName);
}