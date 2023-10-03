package com.coderscampus.chatapplication.service;

import com.coderscampus.chatapplication.domain.Message;
import com.coderscampus.chatapplication.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepo;

	public void save(Message message) {
		messageRepo.save(message);
	}

    public List<Message> getByChannelId(Long channelId) {
		return messageRepo.findById(channelId);
    }

}
