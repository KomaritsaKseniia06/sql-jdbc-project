package com.InventorSoftAcademy;

import com.InventorSoftAcademy.DAL.StudentDataAccessLayer;
import com.InventorSoftAcademy.models.Student;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Main {


    public static void main(String[] args) throws Exception {
        //executing CRUD operations
        Student student = new Student(6L, 23, "Aimee", "Chaney", "AimeeChaney@gmail.com", 5L);
        new StudentDataAccessLayer().read(4L);
        new StudentDataAccessLayer().getAll();
        new StudentDataAccessLayer().create(student);
        new StudentDataAccessLayer().update(student, "Alicia", 2L);
        new StudentDataAccessLayer().delete(6L);
    }
}