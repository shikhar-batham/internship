package com.employwise.employwisebe.repo;

import com.employwise.employwisebe.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee, String> {
    Employee findByEmail(String email);
}
