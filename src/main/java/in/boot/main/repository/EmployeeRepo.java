package in.boot.main.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.boot.main.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Short> {

	public Optional<Employee> findByname(String name);
	
}
