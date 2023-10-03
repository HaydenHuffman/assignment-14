package com.coderscampus.chatapplication.domain;

import java.io.Serializable;

public class Message implements Serializable {
	private String text;
	private User user;
	private Long channelId;

	
	
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Message{" +
				"text='" + text + '\'' +
				", user=" + user +
				", channelId=" + channelId +
				'}';
	}
}
	