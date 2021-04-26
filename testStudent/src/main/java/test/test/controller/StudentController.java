package test.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import test.test.dao.Facult;
import test.test.dao.Student;
import test.test.dao.StudentDto;
import test.test.repo.StudentReposetoriy;

@Controller
public class StudentController {

	@Autowired
	private StudentReposetoriy studentRepo;

	@GetMapping("")
	public String viewHomePage() {

		return "index";
	}

	@GetMapping("/home")
	public String viewHomeMainPage() {

		return "home";
	}

	@GetMapping("/register")
	public String registration(Model model) {
		model.addAttribute("userform", new Student());

		return "registration";
	}

	@PostMapping("/register")
	public ModelAndView uploadImg(@RequestParam("img") MultipartFile img, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam Facult facult, Model model)
			throws IOException {

		studentRepo.save(StudentDto.createEntity(img, firstName, lastName, facult, email));

		return new ModelAndView("registration");

	}

	@PostMapping("/process_register")
	public String processRegister(Student student) {

		if (!student.getPassword().equals(student.getPasswordConfirm())) {
			return "redirect:/register";
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(student.getPassword());
		student.setPassword(encodedPassword);

		studentRepo.save(student);

		return "register_success";
	}

	@GetMapping("/aboutUs")
	public String about(Model model) {
		return "aboutUs";
	}

	@GetMapping("/allStudents")
	public String allStudents(Model model) {

		Iterable<Student> students = studentRepo.findAll();
		model.addAttribute("students", students);
		return "allStudents";
	}

	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		return "addStudent";
	}

	@GetMapping("/listStudents")
	public String listOfStudents(Model model) {
		
		List<Student> students = studentRepo.findAll();
		model.addAttribute("listStudents", students);
		return "listOfStudents";
	}

	@PostMapping("/addStudent")
	public ModelAndView addStudentPost(@RequestParam("img") MultipartFile img, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam Facult facult, Model model)
			throws IOException {

		studentRepo.save(StudentDto.createEntity(img, firstName, lastName, facult, email));

		return new ModelAndView("redirect:/allStudents");
	}

	@GetMapping("/Student/{id}/edit")
	public String editStudent(@PathVariable(value = "id") long id, Model model) {
		if (!studentRepo.existsById(id)) {
			return "redirect:/allStudents";
		}

		Optional<Student> student = studentRepo.findById(id);
		ArrayList<Student> res = new ArrayList<>();
		student.ifPresent(res::add);
		model.addAttribute("student", res);

		return "editStudent";

	}

	@PostMapping("/Student/{id}/edit")
	public String editStudentPost(@PathVariable(value = "id") long id, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam Facult facult, Model model) {

		Student student = studentRepo.findById(id).orElseThrow();

		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setFacult(facult);

		studentRepo.save(student);

		return "redirect:/allStudents";
	}

	@GetMapping("/Student/{id}/marks")
	public String marksStudent(@PathVariable(value = "id") long id, Model model) {
		if (!studentRepo.existsById(id)) {
			return "redirect:/allStudents";
		}
		
		Optional<Student> student = studentRepo.findById(id);
		ArrayList<Student> res = new ArrayList<>();
		student.ifPresent(res::add);
		model.addAttribute("student", res);

		return "marksStudent";

	}

	@PostMapping("/Student/{id}/marks")
	public String marksStudentPost(@PathVariable(value = "id") long id, @RequestParam int mark1,
			@RequestParam int mark2, @RequestParam int mark3, @RequestParam int mark4, @RequestParam int mark5,
			Model model) {

		Student student = studentRepo.findById(id).orElseThrow();
		
		double m = (mark1 + mark2 + mark3 + mark4 + mark5)/5;
		
		student.setAverMark(m);
		studentRepo.save(student);

		return "redirect:/allStudents";

	}

	@PostMapping("/Student/{id}/remove")
	public String removeStudentPost(@PathVariable(value = "id") long id, Model model) {

		Student student = studentRepo.findById(id).orElseThrow();

		studentRepo.delete(student);

		return "redirect:/allStudents";
	}

}
