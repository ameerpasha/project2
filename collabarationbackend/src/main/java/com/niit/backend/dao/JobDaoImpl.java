package com.niit.backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.model.Job;

@Repository
@Transactional

public class JobDaoImpl implements IJobDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public JobDaoImpl(SessionFactory sessionFactory2) {
		this.sessionFactory=sessionFactory;
	}

	public void saveJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
		
	}

	public List<Job> getAllJobs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Job");
		return query.list();
		
	}

	

	public Job get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
