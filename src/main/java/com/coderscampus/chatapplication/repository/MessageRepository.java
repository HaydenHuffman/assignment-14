package com.coderscampus.chatapplication.repository;

import com.coderscampus.chatapplication.domain.Message;
import com.coderscampus.chatapplication.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
	
	private List<Message> messages = new ArrayList<>();

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void save(Message message) {
		User user = message.getUser();
		String name = user.getUsername();
		messages.add(message);
		
	}

    public List<Message> findById(Long channelId) {
		List<Message> messagesWithId = new ArrayList<>();
		for (Message message : messages) {
			if (message.getChannelId().equals(channelId)) {
				messagesWithId.add(message);
			}
		}
		return messagesWithId;
    }
}
