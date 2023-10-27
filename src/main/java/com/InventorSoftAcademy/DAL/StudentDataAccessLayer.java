package com.InventorSoftAcademy.DAL;

import com.InventorSoftAcademy.ConnectionManager;
import com.InventorSoftAcademy.exceptions.StudentNotFoundException;
import com.InventorSoftAcademy.models.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataAccessLayer implements DataAccessLayer<Student> {
    static Long studentId;
    static Integer age;
    static String firstname;
    static String lastname;
    static String email;
    static Long facultyId;

    @Override
    public void create(Student student) throws Exception {
        String query = "INSERT INTO students VALUES(?, ?, ?, ?, ?, ?)";
        Connection connection = new ConnectionManager().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, student.getId());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getFirstname());
            statement.setString(4, student.getLastname());
            statement.setString(5, student.getEmail());
            statement.setLong(6, student.getFacultyId());
            statement.executeUpdate();
            System.out.println("Student was added to DB");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Student read(Long id) throws Exception {
        String query = "SELECT * FROM students WHERE student_id = ?";
        Connection connection = new ConnectionManager().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                studentId = resultSet.getLong("student_id");
                age = resultSet.getInt("age");
                firstname = resultSet.getString("firstname");
                lastname = resultSet.getString("lastname");
                email = resultSet.getString("email");
                facultyId = resultSet.getLong("faculty_id");
                System.out.println(studentId + " | " + age + " | " + firstname + " | " + lastname + " " + email + " | " + facultyId);
                return new Student(studentId, age, firstname, lastname, email, facultyId);
            } else {
                throw new StudentNotFoundException("Student not found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @Override
    public void update(Student currentStudent, Student updatedStudent) throws Exception {
        String query =
                "UPDATE students SET age = ?, firstname = ?, lastname = ?, email = ?, faculty_id = ? WHERE student_id = ?";
        Connection connection = new ConnectionManager().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, updatedStudent.getAge());
            statement.setString(2, updatedStudent.getFirstname());
            statement.setString(3, updatedStudent.getLastname());
            statement.setString(4, updatedStudent.getEmail());
            statement.setLong(5, updatedStudent.getFacultyId());
            statement.setLong(6, currentStudent.getId());
            statement.executeUpdate();
            System.out.println("Student with id " + currentStudent.getId() + " was updated successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        String query = "DELETE FROM students WHERE student_id = ?";
        Connection connection = new ConnectionManager().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("Student with id " + id + " was deleted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Student> getAll() throws Exception {
        List<Student> listOfStudents = new ArrayList<>();
        String query = "SELECT * FROM students";
        Connection connection = new ConnectionManager().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                studentId = resultSet.getLong("student_id");
                age = resultSet.getInt("age");
                firstname = resultSet.getString("firstname");
                lastname = resultSet.getString("lastname");
                email = resultSet.getString("email");
                facultyId = resultSet.getLong("faculty_id");

                Student student = new Student(studentId, age, firstname, lastname, email, facultyId);
                listOfStudents.add(student);

                System.out.println(studentId + " | " + age + " | " + firstname + " | " + lastname + " | " + email + " | " + facultyId);
            }
            return listOfStudents;
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }
}

