package com.employwise.employwisebe.controller;

import com.employwise.employwisebe.payload.ApiResponse;
import com.employwise.employwisebe.payload.EmployeeDto;
import com.employwise.employwisebe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto addedEmployeeDto = this.employeeService.addEmployee(employeeDto);

        return new ResponseEntity<>(addedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("/getEmployeeById")
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam String employeeId) {

        EmployeeDto employeeDto = this.employeeService.getEmployeeById(employeeId);

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {

        List<EmployeeDto> employeeDtos = this.employeeService.getAllEmployee();

        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("employeeId") String employeeId) {

        EmployeeDto updatedEmployee = this.employeeService.updateEmployee(employeeDto, employeeId);

        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<ApiResponse>deleteEmployeeById(@PathVariable("employeeId") String employeeId){

        this.employeeService.deleteEmployeeById(employeeId);

        return new ResponseEntity<>(new ApiResponse("Employee was deeted!",true),HttpStatus.OK);
    }
}
