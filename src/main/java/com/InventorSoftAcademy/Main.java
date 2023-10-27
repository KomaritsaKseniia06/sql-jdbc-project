package com.InventorSoftAcademy;
import com.InventorSoftAcademy.DAL.FacultyDataAccessLayer;
import com.InventorSoftAcademy.DAL.StudentDataAccessLayer;
import com.InventorSoftAcademy.models.Faculty;
import com.InventorSoftAcademy.models.Student;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Main {


    public static void main(String[] args) throws Exception {
        //executing CRUD operations with students

        Student student = new Student(6L, 23, "Aimee", "Chaney", "AimeeChaney@gmail.com", 5L);
        Student student1 = new Student(6L, 22, "Alicia", "Chaney", "AliciaChaney@gmail.com", 2L);
        new StudentDataAccessLayer().create(student);
        new StudentDataAccessLayer().read(6L);
        new StudentDataAccessLayer().getAll();
        new StudentDataAccessLayer().update(student, student1);
        new StudentDataAccessLayer().delete(6L);

        //executing CRUD operations with faculties

        Faculty faculty = new Faculty(7L, "Psychology");
        Faculty faculty1 = new Faculty(7L, "Biology");
        new FacultyDataAccessLayer().create(faculty);
        new FacultyDataAccessLayer().read(7L);
        new FacultyDataAccessLayer().getAll();
        new FacultyDataAccessLayer().update(faculty, faculty1);
        new FacultyDataAccessLayer().delete(7L);


    }
}