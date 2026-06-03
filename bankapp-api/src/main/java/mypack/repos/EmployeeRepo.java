package mypack.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import mypack.models.Employee;

// Spring Data MongoDB repository - backed by MongoDB (Cloud Atlas)
public interface EmployeeRepo extends MongoRepository<Employee, String> {
    // Additional query methods can be declared here when needed
}
