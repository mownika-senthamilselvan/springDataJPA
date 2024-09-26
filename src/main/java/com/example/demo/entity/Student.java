package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
		name="tb1_student",
      uniqueConstraints=@UniqueConstraint(
    		  name="email_unique",
    		  columnNames="EmailAddress")
)
public class Student {
	
	@Id
	@SequenceGenerator(name="student_sequence",
	sequenceName="student_sequence",
	allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long studentId;
	private String firstName;
	private String lastName;
	@Column(name="EmailAddress",
			nullable=false)
	private String email;
	
	@Embedded
	private Guardian guardian;
	
	

}
