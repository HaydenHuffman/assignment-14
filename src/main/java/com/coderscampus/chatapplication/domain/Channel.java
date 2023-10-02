package com.coderscampus.chatapplication.domain;

import jakarta.persistence.Entity;


public class Channel {
	private String name;
	private Long channelId;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	
	
}
