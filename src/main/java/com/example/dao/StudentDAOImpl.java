package com.example.dao;

import com.example.model.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public StudentDAOImpl(DataSource dataSource){ //veritabanından çekilen verilerin template e atanması
        this.jdbcTemplate = new JdbcTemplate(dataSource);
            this.jdbcTemplate = this.jdbcTemplate;
    }

    @Override
    public int save(Student s) { //yeni öğrencinin veri tabanına kaydedilmesi
        String  sql = "INSERT INTO students (student_name, student_email) VALUES (?, ?)";
        return jdbcTemplate.update(sql, s.getStudent_name(), s.getStudent_email());
    }

    @Override
    public int update(Student s) { //kayıtlı öğrencinin bilgilerinin güncellenmesi
        String  sql = "UPDATE students SET student_name=?, student_email=? WHERE student_id=?";
        return jdbcTemplate.update(sql, s.getStudent_name(), s.getStudent_email(), s.getStudent_id());
    }

    @Override
    public Student get(Integer student_id) { //veritabanındaki öğrencinin bilgilerinin çekilmesi
        String sql = "SELECT * FROM students WHERE student_id=" + student_id;

        ResultSetExtractor<Student> extractor = new ResultSetExtractor<Student>() {
            @Override
            public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    String student_name = rs.getString("student_name");
                    String student_email = rs.getString("student_email");

                    return new Student(student_id, student_name, student_email);
                }
                return null;
            }
        };

        return jdbcTemplate.query(sql, extractor);
    }

    @Override
    public int delete(Integer student_id) { //kayıtlı öğrencinin kaydının silinmesi
        String sql = "DELETE FROM students WHERE student_id =" + student_id;
        return jdbcTemplate.update(sql);
    }

    @Override
    public List<Student> list() { //çekilen öğrencilerin idlerine göre sıralı bir şekilde listelenmesi
        String sql = "SELECT * FROM students ORDER BY student_id";

        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer student_id = rs.getInt("student_id");
                String student_name = rs.getString("student_name");
                String student_email = rs.getString("student_email");
                return new Student(student_id, student_name, student_email);
            }
        };
        return jdbcTemplate.query(sql, rowMapper);
    }
}
