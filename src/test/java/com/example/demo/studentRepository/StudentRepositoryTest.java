package com.example.demo.studentRepository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.entity.Guardian;
import com.example.demo.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentrespository;
	
	@Test
    public void saveStudent() {
		Student student=Student.builder()
				.email("mownika@gmail.com")
				.firstName("Mownika")
				.lastName("Senthamilselvan")
				//.guardianName("selvan").
				//gauardianMobile("222222222").
				//guardianEmail("selvam@gmail.com")
				.build();
    
		  studentrespository.save(student);		       
    }
	
	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian=Guardian.builder().
				name("Divya")
				.email("Divya@gmail.com")
				.mobile("66666666").build();
				
		Student student=Student.builder()
				.email("mithran@gmail.com")
				.firstName("mithran")
				.lastName("manigandaprabhu").guardian(guardian).build();
		
		studentrespository.save(student);
	}
	
	
	@Test
	public void printAllstudent() {
		List<Student> studentList=studentrespository.findAll();
		
		System.out.print(studentList);
	}
	
	@Test
	public void findByFirstName() {
		List<Student> studentList=studentrespository.findByFirstName("mownika");
		
		System.out.print(studentList);
	}
	
	@Test
	public void printfindByFirstNameContaining() {
		List<Student> studentList=studentrespository.findByFirstNameContaining("M");
		System.out.print(studentList);
	}
	
	@Test
	public void getByEmailAddress() {
		String student=studentrespository.getStudentFirstNameByEmailAddress("mownika@gmail.com");
		
		System.out.print(student);
	}
	
	@Test
	public void updateByEmailId() {
		studentrespository.updateFirstNameByEmailId("Selvam","mownika@gmail.com");
		
	}
}








