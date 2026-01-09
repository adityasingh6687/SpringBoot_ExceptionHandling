package in.boot.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@NotBlank(message = "Employee name is required")
	@Column(name = "emp_name")
	private String name;
	@NotBlank(message = "Email is required")
	@Column(name = "emp_email")
	private String email;
	@NotNull(message = "Salary is required")
	@Min(value = 10000, message = "salary should be max of 10000")
	@Column(name = "emp_salary")
	private float salary;

}
