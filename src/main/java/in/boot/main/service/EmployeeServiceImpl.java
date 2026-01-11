package in.boot.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.boot.main.dto.EmpUpdateDTO;
import in.boot.main.entity.Employee;
import in.boot.main.exception.EmployeeAlreadyExistsException;
import in.boot.main.exception.NoSuchEmpExistsException;
import in.boot.main.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo repo;
    public EmployeeServiceImpl(EmployeeRepo repo)
    {
    	  this.repo = repo;
    }
	
	@Override
	public String addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		 Employee ee = repo.findByname(emp.getName()).orElse(null);
		 if(ee == null)
		 {
			 repo.save(emp);
		 }
		 else
		 {
			 throw new EmployeeAlreadyExistsException("Employee name: "+emp.getName()+" Already exists please choose another name");
		 }
		return "Employee Register Successfully!";
	}

	@Override
	public Employee getEmploye(short id) {
		// TODO Auto-generated method stub
		Employee ee = repo.findById(id).orElse(null);
		if(ee == null)
		{
			throw new NoSuchEmpExistsException("Record not found in database!");
		}
		else
		{
			return ee;
		}
	}
	
	@Override
	public String updateEmployee(short id, EmpUpdateDTO emp) {
		// TODO Auto-generated method stub
		Employee employee = repo.findById(id).orElse(null);
		if(employee == null)
		{
			throw new NoSuchEmpExistsException("Record not found in database!");
		}
		if(emp.getName() == null && emp.getEmail() == null && emp.getSalary() == null)
		{
		     throw new RuntimeException("any one data is required for updation.");	
		}
		if(emp.getName() != null)
		{
			employee.setName(emp.getName());
		}
		if(emp.getEmail() != null)
		{
			employee.setEmail(emp.getEmail());
		}
		if(emp.getSalary() != null)
		{
			employee.setSalary(emp.getSalary());
		}
		repo.save(employee);
		return "Employee update successfully!";
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> all = repo.findAll();
		if(all.isEmpty())
		{
			throw new NoSuchEmpExistsException("database empty");
		}
		else
		{
			return all;
		}
	}
}
