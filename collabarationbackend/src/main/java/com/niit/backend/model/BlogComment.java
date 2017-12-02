package com.niit.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Blog_Comments")
public class BlogComment{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="blog_id")
	
	private Blog blog;
	@ManyToOne
	@JoinColumn(name="user_name")
	private User user_name;
	
	private Date commentedon;
	private String commenttext;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public User getUser_name() {
		return user_name;
	}
	public void setUser_name(User user_name) {
		this.user_name = user_name;
	}
	public Date getCommentedon() {
		return commentedon;
	}
	public void setCommentedon(Date commentedon) {
		this.commentedon = commentedon;
	}
	public String getCommenttext() {
		return commenttext;
	}
	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}
	
	
	
}




