package com.university.shared.entity;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student", schema = "ums",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = { "email" })
				}
		)
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "seq_generator")
	@SequenceGenerator(name = "seq_generator",sequenceName = "student_sequence",allocationSize = 1)
	int studentId;
	@Column(nullable = false)
	String name;
	@Column(nullable = false)
	String email;
	String phone;
	String Address;
	@CreationTimestamp
	Date created_dt;
	
	@ManyToMany
	@JoinTable(
			  name = "student_course", 
			  joinColumns = @JoinColumn(name = "student_id"), 
			  inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<CourseEntity> courses;
}
