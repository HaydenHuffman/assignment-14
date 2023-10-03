package com.coderscampus.chatapplication.service;

import com.coderscampus.chatapplication.domain.Channel;
import com.coderscampus.chatapplication.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
	
	@Autowired
	private ChannelRepository channelRepo;
	private Long channelId = 2L;

	public Channel createNewChannel() {
		Channel channel = new Channel();
		channel.setName("Channel " + channelId);
		channel.setChannelId(channelId++);
		channelRepo.save(channel);
		return channel;
	}

	public List<Channel> findAll() {
		return channelRepo.findAll();
	}

	public Channel findById(Long id) {
		return channelRepo.findById(id);
	}

}
