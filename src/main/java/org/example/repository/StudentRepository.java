package org.example.repository;
import org.example.dto.Student;
import org.example.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student getStudentById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM Student WHERE id=?", new Object[]{id}, new StudentMapper())
                .stream().findAny().orElse(null);
    }

    public Student getStudentByPhone(String phone) {
        return jdbcTemplate.query("SELECT * FROM Student WHERE phone=?", new Object[]{phone}, new StudentMapper())
                .stream().findAny().orElse(null);
    }

    public Integer saveStudent(Student student) {
        Integer result = jdbcTemplate.update("INSERT INTO Student VALUES (?,?,?,?,?,?)",student.getName(),student.getSurname(),student.getPhone(),
                student.getCreatedDate(),student.getGeneralStatus(),student.getStudentRole());
        return result;
    }

    public List<Student> getStudentList() {
        return jdbcTemplate.query("SELECT * FROM Student", new StudentMapper());
    }

    public Integer changeVisitable(Integer id) {
        Integer result = jdbcTemplate.update("UPDATE Student SET Visitable = FALSE WHERE id=?",id);
        return result;
    }
}
