package test.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.annotation.Rollback;

import test.test.dao.Student;
import test.test.repo.StudentReposetoriy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class StudentReposetoriyTest {

	@Autowired
	public StudentReposetoriy studentRepo;

	@Autowired
	public TestEntityManager entityManager;
	
	@Test
	public void testCreateStudent() {
		
		Student student = new Student();
		student.setEmail("rer");
		student.setFirstName("john");
		student.setLastName("Gors");
		student.setFacult(null);
		
		Student savedStudent = studentRepo.save(student);
		
		Student existStudent = entityManager.find(Student.class, savedStudent.getId());
	     
	}

}