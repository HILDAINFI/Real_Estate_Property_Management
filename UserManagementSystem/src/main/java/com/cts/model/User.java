package com.cts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_info")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private int userId;

	@NotBlank(message = "Name is mandatory")
	@Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
	private String userName;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
    
	private String email;
	private String password;
	private String role;
	private long contactNumber;
}
