package com.InventorSoftAcademy.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table(name = "faculties")
public class Faculty {
    @Id
    @Column("faculty_id")
    Long facultyId;
    @Column("faculty_title")
    String facultyTitle;

}
