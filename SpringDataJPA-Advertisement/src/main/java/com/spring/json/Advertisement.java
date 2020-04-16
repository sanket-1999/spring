package com.spring.json;

import java.util.Random;

public class Advertisement {
	private String status,title,name,category,description;
	private long postId;
	private User user;

	
	
	
	
	Random rand = new Random(); 
	int randompostid = rand.nextInt(1000); 
	String randpost = String.valueOf(randompostid);
	
	
	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
		status="OPEN";
		
	}
	
	
	
	public Advertisement(long postId,String name,String title, String category, String description, String status) {
		super();
		
		this.postId = postId;
		this.status = status;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.status="OPEN";
	}
	
	public Advertisement(String name,String title, String category, String description, String status) {
		super();
		
		this.status = status;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.status="OPEN";
	}


	



	


	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Advertisement [postId=" + postId + ", status=" + status + ", title=" + title + ", name=" + name
				+ ", category=" + category + ", description=" + description + ", user=" + user + "]";
	}
	

}
