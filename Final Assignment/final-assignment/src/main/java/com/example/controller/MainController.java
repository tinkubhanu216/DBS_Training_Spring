package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserDao;
import com.example.model.User;

@RestController
public class MainController {
	@Autowired
	UserDao userDao;
	
	
	@RequestMapping(value="/validateuser",method=RequestMethod.POST)
	public String validateController(@RequestBody User user) {
        return userDao.validateUser(user.getUsername(), user.getPassword());     
	}
}
