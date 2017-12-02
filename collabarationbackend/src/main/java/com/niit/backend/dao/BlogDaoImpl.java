package com.niit.backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.niit.backend.model.Blog;
import com.niit.backend.model.BlogComment;
import com.niit.backend.model.User;

@SuppressWarnings("deprecation")
@Repository(value="BlogDao")
public class BlogDaoImpl implements IBlogDao {

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	
 @Transactional
	public  void save(Blog blog) {
		 sessionFactory.getCurrentSession().save(blog);
		
	}
 
 
 @Transactional
	public void update(Blog blog) {
	 sessionFactory.getCurrentSession().update(blog);
	}
 
 
@Transactional
	public void delete(Blog blog) {
	sessionFactory.getCurrentSession().delete(blog);
	
	}


@Transactional
	public Blog get(int id) {
	Session session=sessionFactory.getCurrentSession();
	Blog blog=(Blog)session.get(Blog.class,id);
	return blog;
	
		
	}
@Transactional
	public Blog getName(String name) {
		String hql="from blog where blogId=" +"'"+name+"'";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list=(List<Blog>) query.list();
		
		if(list !=null&& !list.isEmpty()) {
			System.out.println("blog retrived from DaoImpl");
			return list.get(0);
		}else
		{
			return null;
		}	}

	@Transactional
	public List<Blog> viewblogs() {
		List<Blog> list=sessionFactory.getCurrentSession().createCriteria(Blog.class).list();
		return list;
	}
@Transactional
	public void addComment(BlogComment blogcomment) {
		try
		 {
			 sessionFactory.getCurrentSession().save(blogcomment);
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 
			
			 
		 }
	}


@Transactional
public List<Blog> viewallblogs() {
	Session session=sessionFactory.getCurrentSession();
	Criteria ct=session.createCriteria(Blog.class);
	ct.add(Restrictions.eq("status","true"));
	List<Blog>list=ct.list();
	return null;
}

@Transactional
public List<BlogComment> getAllBlogComments(int id) {
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from BlogComment where  blog.blog_id=?");
	query.setInteger(0,id);
	return query.list();
	
	
}





}
