package com.niit.backend.controller;

import java.util.Date;
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

import com.niit.backend.dao.IForumDao;
import com.niit.backend.model.BaseDomain;
import com.niit.backend.model.Forum;
import com.niit.backend.model.User;



@RestController
public class ForumController {
	
	private static final Logger logger =LoggerFactory.getLogger(ForumController.class);
	
	@Autowired
	IForumDao forumDao;
	
	@Autowired
	Forum forum;

	@RequestMapping(value="/forums",method=RequestMethod.GET)
	public ResponseEntity<List<Forum>> listAllForums(){
		logger.debug("calling method listAllBlogs");
		List<Forum>forum=forumDao.viewforums();
		if(forum.isEmpty()) {
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Forum>>(forum,HttpStatus.OK);

	}
	
	@RequestMapping(value="/forum",method=RequestMethod.POST)
	public ResponseEntity<?> createForum(@RequestBody Forum forum,HttpSession httpSession){
		
		
		Date dt=new java.util.Date();
		 forum.setCreation_date(dt.toString());
		 User user=(User) httpSession.getAttribute("logggedInUser");
		
		 forum.setUser_name("student");
		 forum.setStatus("published");
		 try{
			 forumDao.save(forum);
			 return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		 }catch(Exception e)
		 {
			 BaseDomain error=new BaseDomain();
			 return new ResponseEntity<BaseDomain>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		 }
			
	}
	
	
	@RequestMapping(value="/updateForum",method=RequestMethod.PUT)
	public ResponseEntity<Void> updateForum(@RequestBody Forum forum){
		
		forumDao.update(forum);
		return new ResponseEntity<Void>(HttpStatus.OK);
	
		
	}
	
	@RequestMapping(value="/deleteForum/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteForum(@PathVariable int id) {
		Forum forum=forumDao.get(id);
		forumDao.delete(forum);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/forum/{id}",method=RequestMethod.GET)
	public ResponseEntity<Forum> getForum(@PathVariable("id") int forum_id){
		logger.debug("calling method delete forum for forum id: "+ forum_id);
		Forum forum=forumDao.get(forum_id);
		if(forum==null)
		{
			logger.debug("user already exists with is:"+ forum_id);
			forum.setErrormessage("forum saved with id"+forum_id);
			return new ResponseEntity<Forum>(forum,HttpStatus.NOT_FOUND);
		}
		
	logger.debug("forum exist with id:"+forum_id);
	return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		
	}

}
