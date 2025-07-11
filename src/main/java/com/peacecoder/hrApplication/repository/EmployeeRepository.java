package com.peacecoder.hrApplication.repository;

import com.peacecoder.hrApplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstnameIgnoreCaseOrLastnameIgnoreCase(String firstname, String lastname);
}
