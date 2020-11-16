package com.example.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;


@Service
public class UserDao {
	
	@Autowired
	UserRepository userRepository;
	
	
	public String validateUser(String username,String password) {
		List<User> userList=(List<User>) userRepository.findAll();
		for(Iterator iterator = userList.iterator(); iterator.hasNext();) {
			User usr = (User) iterator.next();
			if (usr.getUsername().equals(username) && usr.getPassword().equals(password)) {
				return "Valid User";
			}
		}
		return "Invalid User";
	}
}
