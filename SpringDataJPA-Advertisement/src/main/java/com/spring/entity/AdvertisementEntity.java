package com.spring.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ad_Record")
public class AdvertisementEntity {
	

	@Id
	@GeneratedValue
	@Column(name="adv_ID")
	long postId;
	
	

	
	@Column(name = "adStatus")
	private String status;
	
	@Column(name = "adTitle")
	private String title;
	

	@Column(name = "adName")
	private String name;
	

	@Column(name = "adCategory")
	private String category;
	

	@Column(name = "adDescription")
	private String description;
	
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;
	
	public AdvertisementEntity() {
		super();
		// TODO Auto-generated constructor stub
			this.status="OPEN";
	}
	
	
	public AdvertisementEntity(long postId,String name,String title, String category, String description, String status) {
		super();
		
		this.postId = postId;
		this.status = status;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		
	}
	
	

	public AdvertisementEntity(String name,String title, String category, String description, String status) {
		super();
		
	
		this.status = status;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		
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
	
	
	public UserEntity getUserEntity() {
		return userEntity;
	}



	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	




	@Override
	public String toString() {
		return "AdvertisementEntity [postId=" + postId + ", name=" + name + ", title=" + title + ", category=" + category
				+ ", description=" + description + ", status=" + status + ", userEntity="
				+ userEntity + "]";
	}
	

}