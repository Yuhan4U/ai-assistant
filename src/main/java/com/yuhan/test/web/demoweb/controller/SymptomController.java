package com.yuhan.test.web.demoweb.controller;


import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuhan.test.web.demoweb.service.ChatGPTService;

@RestController
@RequestMapping("/api/symptom")
public class SymptomController {

    @Autowired
    private ChatGPTService chatGPTService;

    @PostMapping("/{diagnose}")
    public String diagnose(
            @PathVariable String diagnose,
            @RequestBody Map<String, String> body) throws IOException {

        String symptoms =diagnose;
        if (symptoms == null || symptoms.trim().isEmpty()) {
            return "No symptoms provided.";
        }

        String reply = chatGPTService.ask(
                "You are a medical assistant. Suggest possible diseases based on these symptoms: " + symptoms
        );

        return reply;
    }
}
