package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Job;

public interface IJobDao {
	
	void saveJob(Job job);
	
	List<Job> getAllJobs();
	
	

	Job get(int id);

}
