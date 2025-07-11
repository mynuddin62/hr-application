package com.peacecoder.hrApplication.service;

import com.peacecoder.hrApplication.entity.Employees;
import com.peacecoder.hrApplication.repository.EmployeeRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class XmlImportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void importFromXml(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Employees employees = (Employees) unmarshaller.unmarshal(new File(filePath));
            employeeRepository.saveAll(employees.getEmployeeList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
