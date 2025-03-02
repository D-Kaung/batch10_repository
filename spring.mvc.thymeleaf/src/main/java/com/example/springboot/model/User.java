package com.example.springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.dao.DuplicateKeyException;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column( nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	@NotEmpty(message = "phone number must be only digits")
    @Pattern(regexp = "\\d+",message = "phone number must be only digits")
	private String phone;

	@Pattern(regexp = "^\\d{1,2}/[A-Za-z]{2,3}\\(N\\)\\d{6}$",message = "NRC must be like nrc format")
	@Column(nullable = false)
	@NotEmpty()
	private String nrc;

	private String address;

	private String location;

	@Column(unique = true, nullable = false)
	private String password;

	@Column(nullable = false,unique = true)
	private String username;

	@Enumerated(EnumType.STRING)
	private Role role;
	
	public User(String name, String phone, String nrc, String address,
			String location, String password, String username) {
		
		this.name = name;
		this.phone = phone;
		this.nrc = nrc;
		this.address = address;
		this.location = location;
		this.password = password;
		this.username = username;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
