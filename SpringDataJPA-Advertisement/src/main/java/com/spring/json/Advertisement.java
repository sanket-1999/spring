package com.spring.json;

import java.time.LocalDateTime;
import java.util.Random;

public class Advertisement {
	private String postId,status,title,name,category,description;
	private long id;
	private LocalDateTime lastUpdate;

	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
		this.postId="";
		this.status="closed";
	}
	
	

	
	public Advertisement(long id,String name,String title, String category, String description,String postId, String status,LocalDateTime lastUpdate) {
		super();
		this.id=id;
		this.postId = postId;
		this.status = status;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.lastUpdate=lastUpdate;
	}
	


	public Advertisement(long id,String name,String title, String category, String description,LocalDateTime lastUpdate) {
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.id=id;
		this.postId="";
		this.status="closed";
		this.lastUpdate=lastUpdate;
	}
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
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
	
	
	

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}




	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}





	@Override
	public String toString() {
		return "Advertisement [postId=" + postId + ", status=" + status + ", title=" + title + ", name=" + name
				+ ", category=" + category + ", description=" + description + ", id=" + id + ", lastUpdate="
				+ lastUpdate + "]";
	}
	

}