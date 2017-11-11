package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.User;

public interface IUserDao {
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean delete(User user);
	
	public User get(int userId);
	
	public User getName(String name);
	
	public List<User> list();
	
	public User isValidUser(String email,String password);
	
	public void setOnline(int userId);
	
	public void setOffline(int userId);
}
