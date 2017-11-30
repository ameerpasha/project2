package com.niit.backend.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
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
@Transactional
	public void saveuser(User user) {
		// TODO Auto-generated method stub
		
		try
		{
			sessionFactory.getCurrentSession().save(user);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
			
		}
		
	}
@Transactional
	public void update(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.update(user); 
		
	}
	@Transactional
	public boolean delete(User user) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
@Transactional
	public User get(int userId) {
	Session session=sessionFactory.getCurrentSession();
	User user=(User)session.get(User.class,userId);
	return user;
		

		
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
		System.out.println("in user daoimpl list");
		return query.list();
		
	
	}
@Transactional
	public User isValidUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("iam here in login");
		System.out.println("user name"+user.getUser_name());
		Query query=session.createQuery("from User where user_name=? and password=?");
		query.setString(0,user.getUser_name());
		query.setString(1,user.getPassword());
		List<User> list=query.list();
		
		if(list!=null) {
			System.out.println(list.size());
			return list.get(0);
		}else {
		return null;
		}
	}

	public void setOnline(int userId) {
		// TODO Auto-generated method stub

	}

	public void setOffline(int userId) {
		// TODO Auto-generated method stub

	}
	

}
