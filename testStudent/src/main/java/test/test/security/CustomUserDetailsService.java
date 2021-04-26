package test.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import test.test.dao.Student;
import test.test.repo.StudentReposetoriy;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentReposetoriy studentRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Student student = studentRepo.findByEmail(email);
		if (student == null) {
			throw new UsernameNotFoundException("Student not found");
		}
		
		
		return new CustomUserDetails(student);
	}

}
