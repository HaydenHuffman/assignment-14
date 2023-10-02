package com.coderscampus.chatapplication.web;

import com.coderscampus.chatapplication.domain.Message;
import com.coderscampus.chatapplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller	
public class MessageController {
	
	@Autowired
	private MessageService messageService;



	@PostMapping("/message")
	public String postMessage(@RequestBody Message message) {
		messageService.save(message);
		return "redirect:/channels/" + message.getChannelId();
		
	}
}
