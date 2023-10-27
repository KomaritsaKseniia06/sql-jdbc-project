package com.InventorSoftAcademy.DAL;

import com.InventorSoftAcademy.ConnectionManager;
import com.InventorSoftAcademy.exceptions.FacultyNotFoundException;
import com.InventorSoftAcademy.models.Faculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDataAccessLayer implements DataAccessLayer<Faculty> {
    static Long facultyId;
    static String facultyTitle;

    @Override
    public void create(Faculty faculty) throws Exception {
        String query = "INSERT INTO faculties VALUES(?, ?)";
        Connection connection = new ConnectionManager().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, faculty.getFacultyId());
            statement.setString(2, faculty.getFacultyTitle());
            statement.executeUpdate();
            System.out.println("Faculty was added to DB");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Faculty read(Long id) throws Exception {
        String query = "SELECT * FROM faculties WHERE faculty_id = ?";
        Connection connection = new ConnectionManager().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                facultyId = resultSet.getLong("faculty_id");
                facultyTitle = resultSet.getString("faculty_title");
                System.out.println(facultyId + " | " + facultyTitle);
                return new Faculty(facultyId, facultyTitle);
            } else {
                throw new FacultyNotFoundException("Faculty not found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

    @Override
    public void update(Faculty currentFaculty, Faculty updatedFaculty) throws Exception {
        String query =
                "UPDATE faculties SET faculty_title = ? WHERE faculty_id = ?";
        Connection connection = new ConnectionManager().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, updatedFaculty.getFacultyTitle());
            statement.setLong(2, currentFaculty.getFacultyId());
            statement.executeUpdate();
            System.out.println("Faculty with id " + currentFaculty.getFacultyId() + " was updated successfully");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void delete(Long id) throws Exception {
        String query = "DELETE FROM faculties WHERE faculty_id = ?";
        Connection connection = new ConnectionManager().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("Faculty with id " + id + " was deleted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public List<Faculty> getAll() throws Exception {
        List<Faculty> listOfFaculties = new ArrayList<>();
        String query = "SELECT * FROM faculties";
        Connection connection = new ConnectionManager().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                facultyId = resultSet.getLong("faculty_id");
                facultyTitle = resultSet.getString("faculty_title");

                Faculty faculty = new Faculty(facultyId, facultyTitle);
                listOfFaculties.add(faculty);

                System.out.println(facultyId + " | " + facultyTitle);
            }
            return listOfFaculties;
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }
}
