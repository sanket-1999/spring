package com.spring.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "Advertisement_Master")
public class AdvertisementEntity {
	

	@Id
	@Column(name="adv_ID")
	long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private String status;
	
	@Column(name="postId")
	private String postId;
	
	@ManyToOne
	private UserEntity userEntity;
	
	@OneToMany
	@JoinColumn(name = "Postedadvertisement")
	private Set<MessageEntity> messageSet;
	
	@Column(name ="Updates")
	private LocalDateTime lastUpdate;
	
	public AdvertisementEntity() {
		super();
		// TODO Auto-generated constructor stub
		this.postId="";
		this.status="OPEN";
	}
	
	
	public AdvertisementEntity(long id,String name,String title, String category, String description,String postId, String status,LocalDateTime lastUpdate) {
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
	
	


	public AdvertisementEntity(long id,String name,String title, String category, String description,LocalDateTime lastUpdate) {
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.id=id;
		this.postId="";
		this.status="OPEN";
		this.lastUpdate=lastUpdate;
	}
	
	


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPostId() {
		return postId;
	}


	public void setPostId(String postId) {
		this.postId = postId;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}


	public Set<MessageEntity> getMessageSet() {
		return messageSet;
	}


	public void setMessageSet(Set<MessageEntity> messageSet) {
		this.messageSet = messageSet;
	}


	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	@Override
	public String toString() {
		return "AdvertisementEntity [id=" + id + ", name=" + name + ", title=" + title + ", category=" + category
				+ ", description=" + description + ", status=" + status + ", postId=" + postId + ", userEntity="
				+ userEntity + ", lastUpdate=" + lastUpdate + "]";
	}
	

}