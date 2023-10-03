package com.coderscampus.chatapplication.web;

import com.coderscampus.chatapplication.domain.Channel;
import com.coderscampus.chatapplication.domain.Message;
import com.coderscampus.chatapplication.service.ChannelService;
import com.coderscampus.chatapplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/channels")
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/{channelId}")
	public String getChannel(@PathVariable Long channelId, ModelMap model) {
		List<Message> messages = messageService.getByChannelId(channelId);
		model.put("messages", messages);
		Channel channel = channelService.findById(channelId);
		model.put("channel", channel);
		return "channel";
	}
	
	
	
	
	@PostMapping("/create")
	public String postChannel() {
		Channel channel = channelService.createNewChannel();
		return "redirect:/welcome";
	}
	
	
}
