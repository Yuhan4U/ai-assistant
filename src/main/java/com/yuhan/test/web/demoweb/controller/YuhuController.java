package com.yuhan.test.web.demoweb.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yuhan.test.web.demoweb.service.ChatGPTService;

//@RestController
//@RequestMapping("/api/robot")
//@CrossOrigin(origins = "*")
public class YuhuController {

    @Autowired
    private ChatGPTService chatGPTService;

    @PostMapping("/talk")
    public Map<String, String> talk(@RequestBody Map<String, String> body) {
        String message = body.get("message");
        try {
        	String prompt=	"You are a friendly talking robot assistant named Yuhu 1.0. "
        			+ "You always reply politely, briefly, and with a cheerful tone.";
            String reply = chatGPTService.ask(message,prompt);
            return Map.of("reply", reply);
        } catch (IOException e) {
            e.printStackTrace();
            return Map.of("reply", "⚠️ Yuhu had a small brain freeze! Try again.");
        }
    }
}
