package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
		return runner -> {
			createMultipleStudent(studentDAO);

//			readStudent(studentDAO);

//			queryForStudent(studentDAO);

//			queryForStudentByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 5;

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Creating student with id: " + studentId);

		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");

		myStudent.setFirstName("Long");
		studentDAO.update(myStudent);

		System.out.println("Update student: " + myStudent);

	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findBylastName("Nguyen");

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object... ");
		Student s1 = new Student("Ngan", "Hehe", "ngancute123@gmail.com");

		System.out.println("Saving the student... ");
		studentDAO.save(s1);

		int theId = s1.getId();
		System.out.println("Saved the student. Generated id: " + theId);

		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 students objects ...");
		Student s1 = new Student("Dat", "Nguyen", "datnguyenduc09@gmail.com");
		Student s2 = new Student ("Tu", "Nguyen", "nhtqpna@gmail.com");
		Student s3 = new Student ("Thuy", "Truong", "thuyc3qp@gmail.com");

		System.out.println("Saving the students ...");
		studentDAO.save(s1);
		studentDAO.save(s2);
		studentDAO.save(s3);
	}

}
