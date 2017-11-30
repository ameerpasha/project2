package com.niit.backend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.dao.IUserDao;
import com.niit.backend.dao.UserDaoImpl;
import com.niit.backend.model.BaseDomain;
import com.niit.backend.model.User;
@RestController
public class UserController {
	
	private static final Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	
	IUserDao userDao;
	
		
	@RequestMapping(value="users",method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		logger.debug("calling method listallusers");
		List<User> user=userDao.list();
		System.out.println("in get");
		if(user.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/user/",method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		logger.debug("calling method create user"+user.getUser_id());
		System.out.println("in user controller");
		if(userDao.get(user.getUser_id())==null)
		{
			userDao.saveuser(user);
		}
		logger.debug("user already exists with is:"+ user.getUser_id());
		user.setErrormessage("user saved with id"+user.getUser_id());
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") int User_id){
		logger.debug("calling method delete user for user_id: "+ User_id);
		User user=userDao.get(User_id);
		if(user==null)
		{
			logger.debug("user already exists with is:"+ User_id);
			user.setErrormessage("user saved with id"+User_id);
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
		}
		else
			userDao.delete(user);
	logger.debug("user deleted successfully");
	return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}

	/*@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") int user_id,@RequestBody User user){
		logger.debug("calling method updateUser" + user.getUser_id());
		if(userDao.get(user_id)==null){
			System.out.println(user.getUser_id());
			logger.debug("user does not exists with id:" + user.getUser_id());		
			user=new User();
			user.setErrormessage("user does not exists with id:" + user.getUser_id());
			return new ResponseEntity<User> (user,HttpStatus.NOT_FOUND);
		}
		userDao.update(user);
		logger.debug("user updated successfully");
		return new ResponseEntity<User> (user,HttpStatus.OK);		
	}*/
	
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public ResponseEntity<?> registeruser(@RequestBody User user){
		try
		{
			System.out.println("i am here");
			user.setIsOnline('f');
			userDao.saveuser(user);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			BaseDomain error=new BaseDomain();
			return new ResponseEntity<BaseDomain>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> isValidUser(@RequestBody User user,HttpSession session){
		System.out.println("In controller");
		User validuser=userDao.isValidUser(user);
		if(validuser==null) {
			BaseDomain error=new BaseDomain();
			
			return new ResponseEntity<BaseDomain>(error,HttpStatus.UNAUTHORIZED);
	}
	validuser.setIsOnline('y');
	userDao.update(validuser);
	session.setAttribute("username",validuser.getUser_name());
	session.setAttribute("userid",validuser.getUser_id());
	
	return new ResponseEntity<User>(validuser,HttpStatus.OK);
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ResponseEntity<?> logout(HttpSession session){
		if(session.getAttribute("username")==null) {
BaseDomain error=new BaseDomain();
			
			return new ResponseEntity<BaseDomain>(error,HttpStatus.UNAUTHORIZED);
		}
		String username=(String)session.getAttribute("username");
		Integer uid=(Integer)session.getAttribute("userid");
		User user=userDao.get(uid);
		user.setIsOnline('n');
		userDao.update(user);
		session.removeAttribute("username");
		session.removeAttribute("userid");
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateuser",method=RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody User user,HttpSession session){
		/*session.setAttribute("username",user.getUser_name());*/
		if(session.getAttribute("username")==null) {
			BaseDomain error=new BaseDomain();
			return new ResponseEntity<BaseDomain>(error,HttpStatus.UNAUTHORIZED);
			
		}
		try {
			userDao.update(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		catch(Exception e) {
			BaseDomain error=new BaseDomain();
			return new ResponseEntity<BaseDomain>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		

	}
}

	    
		
	
	

