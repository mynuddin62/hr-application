package com.peacecoder.hrApplication.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.Data;


@Entity
@Table(name = "employees")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute(name = "id")
    private Long id;

    @XmlElement
    private String firstname;

    @XmlElement
    private String lastname;

    @XmlElement
    private String title;

    @XmlElement
    private String division;

    @XmlElement
    private String building;

    @XmlElement
    private String room;
}
