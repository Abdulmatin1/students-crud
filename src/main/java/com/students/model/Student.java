package com.students.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data if we use @Data  we don't need getters and setters in our Entity
//@AllArgsConstructor  if we use @@AllArgsConstructor  we don't need parameterized constructor in our Entity
//@NoArgsConstructor if we use @NoArgsConstructor we don't need no argument constructor in our Entity
@Entity
@Table(name = "student")
public class Student {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "firs_Name")
	private String firsName;
	@Column(name = "last_Name")
	private String lastName;
	@Column(name = "email")
	private String email;
	
	public Student() {
	 
	}

	public Student(Long id, String firsName, String lastName, String email) {
	 
		this.id = id;
		this.firsName = firsName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	

}
