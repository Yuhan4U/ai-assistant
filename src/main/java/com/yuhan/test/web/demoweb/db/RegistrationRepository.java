package com.yuhan.test.web.demoweb.db;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.test.web.demoweb.pojo.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    Registration findByUserNameAndPassword(String userName, String password);
}
