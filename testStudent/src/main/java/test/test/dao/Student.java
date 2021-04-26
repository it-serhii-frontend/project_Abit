package test.test.dao;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 20)
	private String firstName;

	@Column(nullable = false, length = 20)
	private String lastName;

	@Column(nullable = false, unique = true, length = 45)
	private String email;
	private Facult facult;

	@Column(length = 150)
	private String password;
	
	@Column
	private Role role;
	
	@Lob
	private byte [] img;
	
	@Column
	private int mark;
	
	@Column
	private double AverMark;
	


	public double getAverMark() {
		return AverMark;
	}

	public void setAverMark(double averMark) {
		AverMark = averMark;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Student(String firstName, String lastName, String email, Facult facult, byte[] img) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.facult = facult;
		this.img = img;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

	public Student(Long id, String firstName, String lastName, String email, Facult facult, String password, Role role,
			byte[] img, String passwordConfirm) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.facult = facult;
		this.password = password;
		this.role = role;
		this.img = img;
		this.passwordConfirm = passwordConfirm;
	}

	public Student(String firstName, String lastName, String email, Facult facult, String password,
			String passwordConfirm) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.facult = facult;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	@Column( length = 150)
	private String passwordConfirm;

	

	public Student(Long id, String firstName, String lastName, String email, Facult facult, String password,
			String passwordConfirm) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.facult = facult;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public Student(String firstName, String lastName, String email, Facult facult) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.facult = facult;
	}

	public Student() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Facult getFacult() {
		return facult;
	}

	public void setFacult(Facult facult) {
		this.facult = facult;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((facult == null) ? 0 : facult.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordConfirm == null) ? 0 : passwordConfirm.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (facult != other.facult)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (passwordConfirm == null) {
			if (other.passwordConfirm != null)
				return false;
		} else if (!passwordConfirm.equals(other.passwordConfirm))
			return false;
		if (role != other.role)
			return false;
		return true;
	}



	

}
