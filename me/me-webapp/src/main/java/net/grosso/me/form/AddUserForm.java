package net.grosso.me.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import net.grosso.me.domain.Contact;
import net.grosso.me.domain.Name;
import net.grosso.me.domain.User.Gender;
import net.grosso.me.domain.User.Lock;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class AddUserForm implements Serializable {

	private static final long serialVersionUID = 4295798325688228185L;
	private Integer id;
	private String username;
	private String password;
	private String lastName;
	private String firstName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Lock getLock() {
		return lock;
	}
	public void setLock(Lock lock) {
		this.lock = lock;
	}
	
	private Gender gender;
	private Lock lock; 
	public AddUserForm() {
		super();
	}
	
}
