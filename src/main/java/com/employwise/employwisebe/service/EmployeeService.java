package com.employwise.employwisebe.service;

import com.employwise.employwisebe.payload.EmployeeDto;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.List;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(String id);

    List<EmployeeDto>getAllEmployee();

    EmployeeDto updateEmployee(EmployeeDto employeeDto,String id);

    void deleteEmployeeById(String id);
}
