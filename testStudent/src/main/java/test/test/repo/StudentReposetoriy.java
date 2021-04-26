package test.test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.support.DefaultCrudMethods;
import org.springframework.stereotype.Repository;

import test.test.dao.Student;

@Repository
public interface StudentReposetoriy extends JpaRepository<Student, Long>{

	@Query("SELECT u FROM Student u WHERE u.email=?1")
	Student findByEmail(String email);
}
