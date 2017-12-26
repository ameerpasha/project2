package com.niit.backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.model.Friend;

@Repository
public class FriendDaoImpl implements IFriendDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public FriendDaoImpl(SessionFactory sessionFactory2) {
		// TODO Auto-generated constructor stub
	}
	@Transactional
	public void addFriend(Friend friend) {
		friend.setIsOnline("offline");
		sessionFactory.getCurrentSession().save(friend);
		
	}
	@Transactional
	public void updateFriend(Friend friend) {
		sessionFactory.getCurrentSession().update(friend);
		
	}
	@Transactional
	public void deleteFriend(Friend friend) {
		sessionFactory.getCurrentSession().delete(friend);
		
	}
	@Transactional
	public List<Friend> viewFriends(String name) {
		Criteria ct =sessionFactory.getCurrentSession().createCriteria(Friend.class);
		ct.add(Restrictions.eq("name", name));
		
		List<Friend> list=ct.list();
		return list;
	}
	@Transactional
	public List<Friend> getMyNewfriendRequest(String username) {
		String hql="from Friend where name='" + username +"' and request_status='" + "n'";
		@SuppressWarnings("rawtypes")
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> list=(List<Friend>)query.list();
		
		return list;
	}
	@Transactional
	public void setOnline(int userID) {
		String hql="UPDATE Friend SET isOnline='Y' where id="+userID;
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		
		
	}
	@Transactional
	public void setOffline(int userID) {
		String hql="UPDATE Friend SET isOnline='N' where id="+userID;
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		
	}

}
