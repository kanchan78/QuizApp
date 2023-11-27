package com.example.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quiz.dao.QuestionDao;
import com.example.quiz.model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		// TODO Auto-generated method stub

		try {
			return new ResponseEntity(questionDao.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity("Failed",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity(questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity("Failed",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		try {
			questionDao.save(question);
			return new ResponseEntity("Question is created successfully",HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity("Failed to create question",HttpStatus.BAD_REQUEST);
	}

	
}
