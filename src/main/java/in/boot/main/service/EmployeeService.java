package in.boot.main.service;
import in.boot.main.entity.Employee;

public interface EmployeeService {

	
	public String addEmployee(Employee emp);
	public Employee getEmploye(short id);
	public String updateEmployee(short id,Employee emp);
	
	

}
