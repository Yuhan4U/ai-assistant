package com.yuhan.test.web.demoweb.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuhan.test.web.demoweb.service.ChatGPTService;

@RestController
@RequestMapping("/api/robot")
public class ROBOController {

	@Autowired
	private ChatGPTService chatGPTService;

	// Option 1: Accept JSON body (recommended)
	@PostMapping("/talk")
	public String talk(@RequestBody String text) throws IOException {
		String response=chatGPTService.ask(text);
		return response;
	}

	// Option 2: If you want to send text as form data instead
	// @PostMapping("/talk")
	// public String talk(@RequestParam String text) {
	// return chatGPTService.speak(text);
	// }
}
