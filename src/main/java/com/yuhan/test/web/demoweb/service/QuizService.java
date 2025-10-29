package com.yuhan.test.web.demoweb.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhan.test.web.demoweb.db.QuestionRepository;
import com.yuhan.test.web.demoweb.pojo.Question;

@Service
public class QuizService {

	@Autowired
	private QuestionRepository questionRepository;

	public Question nextQuiz() {
		List<Question> allQuestions = questionRepository.findAll();
		if (allQuestions.isEmpty())
			return null;

		Collections.shuffle(allQuestions);
		return allQuestions.get(0);
	}
	
	public List<Question> getRandomQuestions(int n) {
        List<Question> allQuestions = questionRepository.findAll();
        Collections.shuffle(allQuestions);
        return allQuestions.subList(0, Math.min(n, allQuestions.size()));
    }

}
