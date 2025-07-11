package com.peacecoder.hrApplication.service;

import com.peacecoder.hrApplication.dto.EmployeeDTO;
import com.peacecoder.hrApplication.entity.Employee;
import com.peacecoder.hrApplication.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private EmployeeDTO mapToDTO(Employee entity) {
        EmployeeDTO dto = new EmployeeDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    private Employee mapToEntity(EmployeeDTO dto) {
        Employee entity = new Employee();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public List<EmployeeDTO> listAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepository.findById(id).map(this::mapToDTO);
    }

    @Override
    public List<EmployeeDTO> getEmployeesByName(String name) {
        return employeeRepository
                .findByFirstnameIgnoreCaseOrLastnameIgnoreCase(name, name)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee updatedEntity = mapToEntity(employeeDTO);
        Employee saved = employeeRepository.save(updatedEntity);
        return mapToDTO(saved);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}