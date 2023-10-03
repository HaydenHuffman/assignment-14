package com.coderscampus.chatapplication.repository;

import com.coderscampus.chatapplication.domain.Channel;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChannelRepository{

	private List<Channel> channels = new ArrayList<>();

	@PostConstruct
	public void init() {
		Channel defaultChannel = new Channel();
		defaultChannel.setChannelId(1L); // Set a unique ID for the channel
		defaultChannel.setName("Channel 1"); // Set the name of the channel
		save(defaultChannel);
	}


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
