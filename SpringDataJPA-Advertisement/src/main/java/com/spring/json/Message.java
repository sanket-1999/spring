package com.spring.json;

import java.time.LocalDateTime;

public class Message {
	private long id;
	private String message;
	private User owner;
	private Advertisement advert;
	private LocalDateTime posttime;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(long id, String message, LocalDateTime posttime) {
		super();
		this.id = id;
		this.message = message;
		this.posttime = posttime;

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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Advertisement getAdvert() {
		return advert;
	}

	public void setAdvert(Advertisement advert) {
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
		return "Message [id=" + id + ", message=" + message + ", owner=" + owner + ", advert=" + advert + ", posttime="
				+ posttime + "]";
	}

}