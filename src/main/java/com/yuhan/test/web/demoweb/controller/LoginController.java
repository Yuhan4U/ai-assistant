package com.yuhan.test.web.demoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuhan.test.web.demoweb.pojo.Login;
import com.yuhan.test.web.demoweb.pojo.Registration;
import com.yuhan.test.web.demoweb.service.LoginService;

@RestController
@RequestMapping("/api/user")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<Registration> login(@RequestBody Login login) {

		// Replace with real DB check; for now example with in-memory list
		Registration foundUser = loginService.login(login);

		if (foundUser != null) {
			// Return username and standard as JSON

			return ResponseEntity.ok(foundUser);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}

	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Registration registration) {
		loginService.register(registration);
		return ResponseEntity.ok("✅ Registration successful!");
	}
}
