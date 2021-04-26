package test.test.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class StudentDto {

	public static Student createEntity(MultipartFile img, String firstName, String lastName, Facult facult, String email) throws IOException {
		
		Student student = new Student();
		
		student.setImg(img.getBytes());
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setFacult(facult);
		student.setEmail(email);
		
		return student;
		
	}
}
