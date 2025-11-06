package com.yuhan.test.web.demoweb.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuhan.test.web.demoweb.pojo.TranslationRequest;
import com.yuhan.test.web.demoweb.service.ChatGPTService;

@RestController
@RequestMapping("/api/robot")
public class ROBOController {

	@Autowired
	private ChatGPTService chatGPTService;

	// Option 1: Accept JSON body (recommended)
	@PostMapping("/talk")
	public String talk(@RequestBody String text) throws IOException {
	String prompt=	"You are a friendly talking robot assistant named Yuhu 1.0. "
			+ "You always reply politely, briefly, and with a cheerful tone.";
		String response=chatGPTService.ask(text,prompt);
		return response;
	}
	
	@PostMapping("/guidence")
	public String guidence(@RequestBody Map<String, String> body) throws IOException {
	    String name = body.get("name");
	    String goal = body.get("goal");
	    String std = body.get("std");

	    String prompt = "You are a Career Guide named Yuhu 1.0. You know how to guide a student to meet his " + goal;
	    String userMessage = "I am " + name + ". Guide me to become " + goal + "."
	    		+ "Currently I am studying in " + std+". GIVE ME IN PLAIN TEXT. NO EMOJIS, NOT SPECIAL SYMBOLS. EXPECTING 5 Sentence only ";
	    
	    return chatGPTService.ask(userMessage, prompt);
	}
	
	@PostMapping("/translate")
	public String translate(@RequestBody TranslationRequest request) throws IOException {
		String response=chatGPTService.translate(request);
		return response;
	}

	
}
