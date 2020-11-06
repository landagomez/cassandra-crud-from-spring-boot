package com.fiserv.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiserv.training.model.Test;
import com.fiserv.training.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
	private TestRepository testRepository;
	
	public List<Test> getAllTests() {
		return testRepository.findAll();
	}

	public Test getTest(Long id) {
		Optional<Test> optionalResult = testRepository.findById(id);
		if (optionalResult.isEmpty()) return null;
		return optionalResult.get();
	}

	public Test addTest(Test test) {
		return testRepository.save(test);
	}
	
	public Test updateTest(Test test) {
		return testRepository.save(test);
	}
	
	public void deleteTest(Long id) {
		Optional<Test> optionalResult = testRepository.findById(id);
		if (!optionalResult.isEmpty()) testRepository.delete(optionalResult.get());
	}

}