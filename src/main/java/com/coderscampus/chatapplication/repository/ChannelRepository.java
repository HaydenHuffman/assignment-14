package com.coderscampus.chatapplication.repository;

import com.coderscampus.chatapplication.domain.Channel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChannelRepository{
	
	private List<Channel> channels = new ArrayList<>();
		
	public List<Channel> findAll() {
		return channels;
	}

	public void save(Channel channel) {
		channels.add(channel);
	}

	public Channel findById(Long id) {
		for (Channel channel : channels) {
			if (channel.getChannelId().equals(id) ) {
				return channel;
			}
		}
		return null;
	}

}
