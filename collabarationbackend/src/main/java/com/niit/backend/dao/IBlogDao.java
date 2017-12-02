package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Blog;
import com.niit.backend.model.BlogComment;
import com.niit.backend.model.User;

public interface IBlogDao {
	
	public void save(Blog blog);
	
	public void update(Blog blog);
	
	public void delete(Blog blog);
	
	public Blog get(int id);
	
	public Blog getName(String name);
	
	public List<Blog> viewallblogs();
	
	public List<Blog> viewblogs();
	
	
	
	 void addComment(BlogComment blogComment);
	
	public List<BlogComment> getAllBlogComments(int blogPostId);

	
	
}
