package com.InventorSoftAcademy;
import com.InventorSoftAcademy.DAL.StudentDataAccessLayer;
import com.InventorSoftAcademy.models.Student;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Main {


    public static void main(String[] args) throws Exception {
//        new StudentDataAccessLayer().create(new Student(7L, 23, "Aimee", "Chaney", "AimeeChaney@gmail.com", 5L));
//        new StudentDataAccessLayer().read(2L);
        new StudentDataAccessLayer().getAll();


    }
}