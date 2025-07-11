package com.peacecoder.hrApplication.service;

import com.peacecoder.hrApplication.dto.EmployeeDTO;
import com.peacecoder.hrApplication.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeDTO> listAllEmployees();
    Optional<EmployeeDTO> getEmployeeById(Long id);
    List<EmployeeDTO> getEmployeesByName(String name);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);

}
