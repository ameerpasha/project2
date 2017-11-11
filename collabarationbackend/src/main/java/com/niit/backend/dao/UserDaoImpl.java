package com.niit.backend.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.model.User;

@SuppressWarnings("deprecation")
@Repository(value="IUserDao")

public class UserDaoImpl implements IUserDao {
	
	private static final Logger logger=LoggerFactory.getLogger(UserDaoImpl.class);
	@Autowired 
	
	private SessionFactory sessionFactory;

	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
	}

	public boolean save(User user) {
		// TODO Auto-generated method stub
		
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			
			return false;
		}
		
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User get(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
@SuppressWarnings("unchecked")
@Transactional
	public List<User> list() {
		// TODO Auto-generated method stub
		String hql= "from User";
		@SuppressWarnings("rawtypes")
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
		
	
	}

	public User isValidUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setOnline(int userId) {
		// TODO Auto-generated method stub

	}

	public void setOffline(int userId) {
		// TODO Auto-generated method stub

	}

}
