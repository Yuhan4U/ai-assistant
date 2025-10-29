package com.yuhan.test.web.demoweb.db;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.test.web.demoweb.pojo.UserScore;

public interface UserScoreRepository extends JpaRepository<UserScore, Long> {
    List<UserScore> findTop5ByOrderByScoreDesc();
}
