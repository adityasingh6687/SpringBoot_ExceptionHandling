package in.boot.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import in.boot.main.entity.Employee;
import in.boot.main.exception.EmployeeAlreadyExistsException;
import in.boot.main.exception.ErrorResponse;
import in.boot.main.exception.NoSuchEmpExistsException;
import in.boot.main.service.EmployeeServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/emp")
public class MyController {

	private EmployeeServiceImpl service;

	public MyController(EmployeeServiceImpl service) {
		this.service = service;
	}

	@PostMapping("/add")
	public String addEmp(@Valid @RequestBody Employee emp) {
		String msg = service.addEmployee(emp);
		return msg;
	}

	@GetMapping("/get/{id}")
	public Employee getEmp(@PathVariable short id) {
		Employee employe = service.getEmploye(id);
		return employe;
	}

	@PutMapping("/update/{id}")
	public String updateEmployee(@PathVariable short id, @Valid @RequestBody Employee emp) {
		String msg = service.updateEmployee(id, emp);
		return msg;
	}

	@GetMapping("/getAll")
	public List<Employee> getAllEmployee() {
		List<Employee> list = service.getAllEmployee();
		return list;
	}

//	@ExceptionHandler(value=NoSuchEmpExistsException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//     public ErrorResponse handleNoSuchEmpExistException(NoSuchEmpExistsException ex)
//     {
//		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
//		return error;
//     }
//	  
//	@ExceptionHandler(value=EmployeeAlreadyExistsException.class)
//	@ResponseStatus(HttpStatus.CONFLICT)
//    public ErrorResponse handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex)
//    {
//		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
//		return error;
//    }

}
