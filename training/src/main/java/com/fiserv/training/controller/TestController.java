package com.fiserv.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiserv.training.model.Test;
import com.fiserv.training.service.TestService;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/tests")
	public ResponseEntity<List<Test>> getAllTests() {
		return ResponseEntity.ok().body(testService.getAllTests());
	}
	
	@GetMapping("/tests/{id}")
	public ResponseEntity<Test> getTest(@PathVariable Long id) {
		return ResponseEntity.ok().body(testService.getTest(id));
	}
	
	@PostMapping("/tests")
	public ResponseEntity<Test> addTest(@RequestBody Test test) {
		return ResponseEntity.ok().body(testService.addTest(test));
	}
	
	@PutMapping("/tests")
	public ResponseEntity<Test> updateTest(@RequestBody Test test) {
		return ResponseEntity.ok().body(testService.updateTest(test));
	}
	
	@DeleteMapping("/tests/{id}")
	public ResponseEntity<Test> deleteTest(@PathVariable Long id) {
		testService.deleteTest(id);
		return ResponseEntity.noContent().build();
	}
}
