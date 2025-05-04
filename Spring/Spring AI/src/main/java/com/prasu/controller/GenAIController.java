package com.prasu.controller;

import com.prasu.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GenAIController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/ask-ai")
    public String getResponser(@RequestParam String prompt) {
        return chatService.getResponse(prompt);
    }
}
