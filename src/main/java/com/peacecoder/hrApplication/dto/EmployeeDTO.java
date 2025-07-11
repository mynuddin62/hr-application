package com.peacecoder.hrApplication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String title;
    private String division;
    private String building;
    private String room;
}
