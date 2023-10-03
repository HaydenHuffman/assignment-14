package com.coderscampus.chatapplication.web;

import com.coderscampus.chatapplication.domain.Message;
import com.coderscampus.chatapplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@GetMapping("/message/{channelId}")
	public List<Message> getMessages(@PathVariable Long channelId) {
		try {
			List<Message> messages = messageService.getByChannelId(channelId);
			return messages;
		} catch (Exception e) {
			e.printStackTrace();
			// Handle the exception and return an appropriate error response
			return Collections.emptyList(); // or throw a specific exception
		}
	}
	@PostMapping("/message")
	public Message postMessage(@RequestBody Message message) {
		messageService.save(message);
		System.out.println(message);
		return message;
		
	}
}
