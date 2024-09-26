package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

import jakarta.transaction.Transactional;


@Repository
public interface StudentRepository extends JpaRepository<Student ,Long > {
	
	 List<Student> findByFirstName(String firstName);
	 List<Student> findByFirstNameContaining(String Name);
	 
	 List<Student> findByLastNameNotNull();
	 
	 
	 List<Student> findByGuardianName(String name);
	 
	 Student findByFirstNameAndLastName(String firstName,String LastName);
	 
//	 @Query("select s from student s where s.emailAddress.=?1")
//	 Student getStudentByEmailAddress(String name);
	 
	 
	 @Query("select s.firstName from Student s where s.email = ?1")
	    String getStudentFirstNameByEmailAddress(String emailId);
	 
	 
	 @Transactional
	 @Modifying
	 @Query(
	            value = "update schooldb.tb1_student set first_name = ?1 where email_address = ?2",
	            nativeQuery = true
	    )
	 int updateFirstNameByEmailId(String FirstName,String emailId);

}
