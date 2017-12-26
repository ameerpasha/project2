 package com.niit.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backend.dao.BlogDaoImpl;
import com.niit.backend.dao.ForumDaoImpl;
import com.niit.backend.dao.FriendDaoImpl;
import com.niit.backend.dao.IBlogDao;
import com.niit.backend.dao.IForumDao;
import com.niit.backend.dao.IFriendDao;
import com.niit.backend.dao.IJobDao;
import com.niit.backend.dao.IUserDao;
import com.niit.backend.dao.JobDaoImpl;
import com.niit.backend.dao.UserDaoImpl;
import com.niit.backend.model.Blog;
import com.niit.backend.model.BlogComment;
import com.niit.backend.model.Forum;
import com.niit.backend.model.Friend;
import com.niit.backend.model.Job;
import com.niit.backend.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class ApplicationContext {
	@Bean(name= "dataSource")
	public DataSource getdatasource() {
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("AMEERDB");
		dataSource.setPassword("ameerabhi");
		System.out.println("data source");
		return dataSource;
	}
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.format_sql","true");
		properties.put("hibernate.jdbc.use_get_generated_keys","true");
		System.out.println("hibernate");
		return properties;
		
		
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(User.class);
	    sessionBuilder.addAnnotatedClass(Blog.class);
	    /*sessionBuilder.addAnnotatedClass(BlogComment.class);*/
	    sessionBuilder.addAnnotatedClass(Forum.class);
	    sessionBuilder.addAnnotatedClass(Job.class);
	    sessionBuilder.addAnnotatedClass(Friend.class);
		System.out.println("session factory");
		return sessionBuilder.buildSessionFactory();
		
		
	}
	
	
	@Autowired
	@Bean(name="user")
	public User getUser()
	{
		return new User();
	}
	
	@Autowired
	@Bean(name="userDao")
	public IUserDao getUserDao(SessionFactory sessionFactory)
	{
		return new UserDaoImpl(sessionFactory);
	}
		
		@Autowired
		@Bean(name="blogDao")
		public IBlogDao getBlogDao(SessionFactory sessionFactory)
		{
			return new BlogDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean(name="blog")
		public Blog getBlog()
		{
			return new Blog();
			
		}	
		
		@Autowired
		@Bean(name="forum")
		public Forum getForum()
		{
			return new Forum();
			
		}	
		@Autowired
		@Bean(name="forumDao")
		public IForumDao getForumDao(SessionFactory sessionFactory)
		{
			return new ForumDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean(name="job")
		public Job getJob()
		{
			return new Job();
			
		}	
		@Autowired
		@Bean(name="jobDao")
		public IJobDao getJobDao(SessionFactory sessionFactory)
		{
			return new JobDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean(name="friend")
		public Friend getFriend()
		{
			return new Friend();
			
		}	
		@Autowired
		@Bean(name="friendDao")
		public IFriendDao getFriendDao(SessionFactory sessionFactory)
		{
			return new FriendDaoImpl(sessionFactory);
		}
		
		
	
		@Autowired
		@Bean(name="blog_comment")
		public BlogComment getBlogComment()
		{
			return new BlogComment();
		}

	@Autowired
	@Bean(name ="transactionmanager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager =new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
	}
	
	

}
