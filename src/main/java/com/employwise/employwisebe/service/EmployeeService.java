package com.employwise.employwisebe.service;

import com.employwise.employwisebe.payload.EmployeeDto;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(String id);

    List<EmployeeDto>getAllEmployee();

    EmployeeDto updateEmployee(EmployeeDto employeeDto,String id);

    void deleteEmployeeById(String id);

    EmployeeDto uploadImage(String id, String path, MultipartFile file) throws IOException;
}
