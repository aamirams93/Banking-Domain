package com.excelsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelsoft.dao.UserDao;
import com.excelsoft.enties.User;

@RestController
public class MyController {
	@Autowired
private UserDao userDao;
	@GetMapping("/")
	public String home() {
		return "<h1> Home Page</h1>";
	}
	@GetMapping("/user")
	public String user() {
		return "<h1> User Page</h1>";
	}
	
	@GetMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	public String update() {
		return"<h1> Update Page</h1>";
	}
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userDao.registerNewUser(user);
	}
}