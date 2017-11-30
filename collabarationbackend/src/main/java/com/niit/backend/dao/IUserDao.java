package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.User;

public interface IUserDao {
	
	public void saveuser(User user);
	
	public void update(User user);
	
	public boolean delete(User user);
	
	public User get(int userId);
	
	public User getName(String name);
	
	public List<User> list();
	
	public User isValidUser(User user);
	
	public void setOnline(int userId);
	
	public void setOffline(int userId);
}
