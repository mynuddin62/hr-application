package com.peacecoder.hrApplication.runner;

import com.peacecoder.hrApplication.service.XmlImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class XmlImporterRunner implements CommandLineRunner {

    private final XmlImportService xmlImportService;

    public XmlImporterRunner(XmlImportService xmlImportService) {
        this.xmlImportService = xmlImportService;
    }

    @Override
    public void run(String... args) {
        xmlImportService.importFromXml("src/main/resources/employee.xml");
    }
}

