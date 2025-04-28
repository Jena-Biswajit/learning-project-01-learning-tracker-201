package com.example.daos;

import com.example.dto.Student;
import com.example.servlets.StudentServletExamples;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class StudentDaoImpl implements StudentDao {

    private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

    // Database Credentials
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String JDBC_USER = "root"; // Change username
    private static final String JDBC_PASSWORD = "subhasmita"; // Change password

    @Override
    public boolean save(Student student) throws ClassNotFoundException {
        return insertStudentIntoDatabase(student);
    }

    private boolean insertStudentIntoDatabase(Student student) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO student (name, age) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            logger.info("[StudentServletExamples]Database connected successfully!");

            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());

            int rowsInserted = statement.executeUpdate();

            // Retrieve generated ID if needed
            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        student.setId(generatedKeys.getInt(1)); // Assuming Student has a setId() method
                    }
                }
            }

            return rowsInserted > 0;
        } catch (SQLException e) {
            logger.error("[StudentServletExamples] Database error: {}", e.getMessage(), e);
        }
        return false;
    }
}
