package com.niit.backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.backend.model.Blog;
import com.niit.backend.model.Forum;

public class ForumDaoImpl implements IForumDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ForumDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}
	@Transactional
	public void save(Forum forum) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(forum);
		
	}
	@Transactional
	public void update(Forum forum) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(forum);
		
	}
	@Transactional
	public void delete(Forum forum) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(forum);
		
	}
	@Transactional
	public Forum get(int id) {
		Session session=sessionFactory.getCurrentSession();
		Forum forum=(Forum)session.get(Forum.class,id);
		return forum;
		
			
		}
	@Transactional
	public Forum getName(String name) {
		// TODO Auto-generated method stub
		
		String hql="from forum where blogId=" +"'"+name+"'";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> list=(List<Forum>) query.list();
		
		if(list !=null&& !list.isEmpty()) {
			System.out.println("forum retrived from DaoImpl");
			return list.get(0);
		}else
		{
			return null;
		}	}
	@Transactional
	public List<Forum> viewallforums() {
		
		Session session=sessionFactory.getCurrentSession();
		Criteria ct=session.createCriteria(Forum.class);
		ct.add(Restrictions.eq("status","true"));
		List<Forum>list=ct.list();

		
		return null;
	}
	@Transactional
	public List<Forum> viewforums() {
		// TODO Auto-generated method stub
		List<Forum> list=sessionFactory.getCurrentSession().createCriteria(Forum.class).list();
		return list;
	}

}
