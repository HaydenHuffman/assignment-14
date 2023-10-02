package com.coderscampus.chatapplication.web;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coderscampus.chatapplication.domain.Channel;
import com.coderscampus.chatapplication.domain.User;
import com.coderscampus.chatapplication.service.ChannelService;
import com.coderscampus.chatapplication.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChannelService channelService;
    
    @GetMapping("/welcome")
    public String getWelcome(ModelMap model) {
    	List<Channel> channels = channelService.findAll();
    	model.put("channels", channels);
        return "welcome";
    }

    @PostMapping("/welcome")
    public String postWelcome(@RequestBody String username) {
    	User user = new User();
        Optional<User> existingUser = userService.findByUsername(username);

        if (existingUser.isPresent()) {
            user = existingUser.get();
        } else {       
            user.setUsername(username);
            userService.save(user);
        }
        return "redirect:/welcome";
    }	
}
