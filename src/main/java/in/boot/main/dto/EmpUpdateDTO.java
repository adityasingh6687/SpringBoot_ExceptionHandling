package in.boot.main.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmpUpdateDTO {

	@Size(min=1,message="name can't be null")
	private String name;
	@Size(min=1,message="email can't be null")
	private String email;
	@Min(value=10000,message="salary is greater than 10000")
	private Float salary;
	
}
