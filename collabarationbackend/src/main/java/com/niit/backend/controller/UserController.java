package com.niit.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.backend.dao.IUserDao;
import com.niit.backend.dao.UserDaoImpl;
import com.niit.backend.model.User;

public class UserController {
	
	private static final Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	
	IUserDao userDao;
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		logger.debug("calling method listallusers");
		List<User> user=userDao.list();
		if(user.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<User>>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		logger.debug("calling method create user"+user.getUser_id());
		System.out.println("in user controller");
		if(userDao.get(user.getUser_id())==null)
		{
			userDao.save(user);
		}
		logger.debug("user already exists with is:"+ user.getUser_id());
		user.setErrormessage("user saved with id"+user.getUser_id());
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}


}
