package com.yuhan.test.web.demoweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhan.test.web.demoweb.db.RegistrationRepository;
import com.yuhan.test.web.demoweb.pojo.Login;
import com.yuhan.test.web.demoweb.pojo.Registration;

@Service
public class LoginService {

	
	@Autowired
	private RegistrationRepository registrationRepository;

	public Registration login(Login login) {
		
		return registrationRepository.findByUserNameAndPassword(login.getUserName(), login.getPassword());
	}

	public void register(Registration registration) {
	
		registrationRepository.save(registration);
	}

}
