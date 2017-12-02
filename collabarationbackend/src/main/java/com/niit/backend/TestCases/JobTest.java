package com.niit.backend.TestCases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.IJobDao;
import com.niit.backend.model.Job;

public class JobTest {

	static IJobDao jobDao;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit");
		annotationConfigApplicationContext.refresh();
		jobDao = (IJobDao) annotationConfigApplicationContext.getBean("jobDao");
	}

	
	@Test
	public void saveJobs() {
		Job job = new Job();
		job.setJobdescription("jobs");;
		job.setId(22);;
		job.setYearsofexp("0");
		job.setSkillrequired("xyz");
		
		

	}

	@Ignore
	@Test
	public void deleteJobs() {
		Job jobs = (Job) jobDao.get(1);
		
	}

	@Ignore
	@Test
	public void updateJobs() {
		Job jobs = (Job) jobDao.get(2);
		jobs.setJobdescription("done");
		
		
	}

	@Ignore
	@Test
	public void getAllJobs() {
		List<Job> jobList = (List<Job>) jobDao.getAllJobs();
		assertNotNull("blog is null", jobList.get(0));
		for (Job jobs : jobList) {
			System.out.println("jobs is" + jobs.getJobdescription() + ":::" + "job name::" + jobs.getJob_title() + "");
		}
	}
	@Ignore
	@Test
	public void getJobs()
	{
		Job jobs=(Job)jobDao.get(2);
		assertNotNull("error",jobs);
		System.out.println("jobs desc is "+jobs.getJobdescription());
		System.out.println("jobs title"+jobs.getJob_title());
	
	}

}
