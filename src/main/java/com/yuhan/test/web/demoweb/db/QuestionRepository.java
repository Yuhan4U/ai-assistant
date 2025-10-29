package com.yuhan.test.web.demoweb.db;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.test.web.demoweb.pojo.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    boolean existsByQuestion(String question);
}
