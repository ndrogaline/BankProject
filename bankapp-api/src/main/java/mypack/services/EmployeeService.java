package mypack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mypack.models.Employee;
import mypack.repos.EmployeeRepo;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee emp) {
        // Basic placeholder logic - add validation here as needed
        if (emp == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        // If caller provided an int-style id previously, ensure the id field is OK for Mongo
        return employeeRepo.save(emp);
    }

    /**
     * Return all Employee documents from MongoDB.
     */
    public List<Employee> getAllUsers() {
        return employeeRepo.findAll();
    }
}
