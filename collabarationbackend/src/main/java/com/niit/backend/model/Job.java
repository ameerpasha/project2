package com.niit.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Job")

public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	
	private long id;
	private String job_title;
	private String jobdescription;
	private String skillrequired;
	private String yearsofexp;
	private String salary;
	private String companyname;
	private String location;
	private Date postedon;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	public String getSkillrequired() {
		return skillrequired;
	}
	public void setSkillrequired(String skillrequired) {
		this.skillrequired = skillrequired;
	}
	public String getYearsofexp() {
		return yearsofexp;
	}
	public void setYearsofexp(String yearsofexp) {
		this.yearsofexp = yearsofexp;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getPostedon() {
		return postedon;
	}
	public void setPostedon(Date postedon) {
		this.postedon = postedon;
	}
	
	
	
	
	
	
	

}
