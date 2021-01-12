package com.students.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.students.exception.StudentNotFoundException;
import com.students.model.Student;
import com.students.repository.StudentRepository;

@RestController
@RequestMapping("/students/v1")
public class StudentsController {

	@Autowired
	private StudentRepository studentRepository;

	// gets all students
	@GetMapping("/students")
	public List<Student> getAllStudents() {

		return studentRepository.findAll();

	}

	// post student

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {

		return studentRepository.save(student);
	}

	// update Students

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> upadateStudent(@PathVariable("id") Long id, @RequestBody Student studentDetails) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not exits with id " + id));

		student.setFirsName(studentDetails.getFirsName());
		student.setLastName(studentDetails.getLastName());
		student.setEmail(studentDetails.getEmail());

		Student upadateStudent = studentRepository.save(student);

		return ResponseEntity.ok(student);

	}

	// get studetn by id

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentsById(@PathVariable("id") Long id) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not exits with id " + id));

		return ResponseEntity.ok(student);
	}
	
	
	
	
	// delete student
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent( @PathVariable("id")  Long id){
		
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not exits with id " + id));

		studentRepository.delete(student);
		Map <String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);	
		
		
		
		return ResponseEntity.ok(response);
		
	}
	
	

}
