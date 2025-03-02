package com.university.shared.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course", schema = "ums",
uniqueConstraints = {
		@UniqueConstraint(columnNames = { "title" })
		}
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String title;
	
	@Column
	private String fee;
	
	@ManyToMany(mappedBy = "courses")
	private Set<StudentEntity> students;
}
