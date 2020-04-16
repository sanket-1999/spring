package com.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message_Record")
public class MessageEntity {
	
	@Id
	@Column(name = "msg_id")
	private long id;
	
	@Column(name = "message")
	private String message;
	
	@ManyToOne
	private UserEntity owner;
	
	@ManyToOne
	private AdvertisementEntity advert;
	
	@Column(name ="date")
	private LocalDateTime posttime;
	
	public MessageEntity() {
		super();
		
	}
	public MessageEntity(long id, String message,LocalDateTime posttime) {
		super();
		this.id = id;
		this.message = message;
		this.posttime=posttime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserEntity getOwner() {
		return owner;
	}
	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}
	public AdvertisementEntity getAdvertt() {
		return advert;
	}
	public void setAdvert(AdvertisementEntity advert) {
		this.advert = advert;
	}
	
	
	public LocalDateTime getPosttime() {
		return posttime;
	}
	public void setPosttime(LocalDateTime posttime) {
		this.posttime = posttime;
	}
	
	@Override
	public String toString() {
		return "MessageEntity [id=" + id + ", message=" + message + ", owner=" + owner
				+ ", advert=" + advert + ", posttime=" + posttime + "]";
	}
	
}