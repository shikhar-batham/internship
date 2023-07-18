package com.employwise.employwisebe.service.employeeServiceImpl;

import com.employwise.employwisebe.entity.Employee;
import com.employwise.employwisebe.exceptions.ResourceNotFoundException;
import com.employwise.employwisebe.payload.EmployeeDto;
import com.employwise.employwisebe.repo.EmployeeRepo;
import com.employwise.employwisebe.service.EmployeeService;
import com.employwise.employwisebe.service.FileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FileService fileService;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();

        Employee employee = this.modelMapper.map(employeeDto, Employee.class);
        employee.setUuid(uuidString);

        Employee savedEmployee = this.employeeRepo.save(employee);

        return this.modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(String id) {

        Employee fetchedEmployee = this.employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "employee_id", id));

        return this.modelMapper.map(fetchedEmployee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {

        List<Employee> fetchedEmployeesList = this.employeeRepo.findAll();

        return fetchedEmployeesList.stream().map(employee -> this.modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, String id) {

        Employee fetchedEmployee = this.employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "employee_id", id));

        fetchedEmployee.setName(employeeDto.getName());
        fetchedEmployee.setEmail(employeeDto.getEmail());
        fetchedEmployee.setPhoneNumber(employeeDto.getPhoneNumber());
        fetchedEmployee.setManagerId(employeeDto.getManagerId());

        Employee savedEmployee = this.employeeRepo.save(fetchedEmployee);

        return this.modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployeeById(String id) {

        Employee fetchedEmployee = this.employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "employee_id", id));

        this.employeeRepo.delete(fetchedEmployee);
    }

    @Override
    public EmployeeDto uploadImage(String id, String path, MultipartFile file) throws IOException {
        Employee employee = this.employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Provider", "provider id", id));
        String providerImage = this.fileService.uploadImage(path, file);
        employee.setProfileImage(providerImage);
        this.employeeRepo.save(employee);

        return this.modelMapper.map(employee, EmployeeDto.class);
    }
}
