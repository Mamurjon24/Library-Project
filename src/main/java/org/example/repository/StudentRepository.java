package org.example.repository;
import org.example.db.DataBase;
import org.example.dto.Book;
import org.example.dto.Student;
import org.example.enums.GeneralStatus;
import org.example.enums.StudentRole;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Repository
public class StudentRepository {
    public Student getStudentById(Integer id) {
        Connection connection = null;
        try {
            connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select  * from student where visitable = true and phone= '%s';", id);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreatedDate(LocalDateTime.parse(resultSet.getString("created_date")));
                student.setGeneralStatus(GeneralStatus.valueOf(resultSet.getString("general_status")));
                student.setStudentRole(StudentRole.valueOf(resultSet.getString("student_role")));
                student.setVisitable(Boolean.parseBoolean(resultSet.getString("visible")));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return null;
    }
    public Student getStudentByPhone(String phone) {
        Connection connection = null;
        try {
            connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select  * from student where phone= '%s';", phone);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreatedDate(LocalDateTime.parse(resultSet.getString("created_date")));
                student.setGeneralStatus(GeneralStatus.valueOf(resultSet.getString("general_status")));
                student.setStudentRole(StudentRole.valueOf(resultSet.getString("student_role")));
                student.setVisitable(Boolean.parseBoolean(resultSet.getString("visible")));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return null;
    }
    public Integer saveStudent(Student student) {
        Connection connection = DataBase.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into student(name,surname,phone,created_date,general_status,student_role) " +
                            "values (?,?,?,?,?,?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getPhone());
            statement.setTimestamp(4, Timestamp.valueOf(student.getCreatedDate()));
            statement.setString(5, student.getGeneralStatus().name());
            statement.setString(6,student.getStudentRole().name());
            int resultSet = statement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    public List<Student> getStudentList() {
        try (Connection connection = DataBase.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            List<Student> result = new LinkedList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setGeneralStatus(GeneralStatus.valueOf(resultSet.getString("general_status")));
                student.setStudentRole(StudentRole.valueOf(resultSet.getString("student_role")));
                student.setVisitable(resultSet.getBoolean("visible"));
                result.add(student);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
    public int changeVisitable(Integer num) {
        try (Connection connection = DataBase.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update student set visible = false where id = ? ;");
            statement.setInt(1, num);
            int resultSet = statement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return 0;
    }
}
