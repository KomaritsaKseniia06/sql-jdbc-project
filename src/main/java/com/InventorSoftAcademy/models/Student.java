package com.InventorSoftAcademy.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @Column("student_id")
    private Long id;
    private Integer age;
    private String firstname;
    private String lastname;
    private  String email;
    @Column("faculty_id")
    private Long facultyId;
}
