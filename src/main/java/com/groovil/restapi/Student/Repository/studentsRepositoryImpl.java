package com.groovil.restapi.Student.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.groovil.restapi.Exceptions.EtAuthException;
import com.groovil.restapi.Student.students;

@Repository
public class studentsRepositoryImpl implements StudentsReposiory{
    

    private static final String SQL_CREATE = "INSERT INTO students(name, rollnumber) VALUES(?, ?)";
    private static final String SQL_COUNT_BY_ROLL_NUMBER = "SELECT COUNT(*) FROM students WHERE rollnumber = ?";
    private static final String SQL_FIND_BY_ID = "SELECT * from students where id=?";
    private static final String SQL_FIND_BY_EMAIL = "SELECT id, rollnumber, name, dob FROM students WHERE id= ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String Name, String rollNumber) throws EtAuthException {
        try {
            System.out.println("Repository layer hit!!!");
            KeyHolder keyHolder = new GeneratedKeyHolder();

            PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(SQL_CREATE, Types.VARCHAR, Types.VARCHAR);
            pscf.setReturnGeneratedKeys(true);
            PreparedStatementCreator psc = pscf.newPreparedStatementCreator(Arrays.asList(Name, rollNumber));
            jdbcTemplate.update(psc, keyHolder);
            return (Integer) keyHolder.getKey().intValue();
        } catch (Exception e) {
            throw new EtAuthException("Invalid details. Failed to create a new student" + e);    
        }
    }

    @Override
    public Integer getCountByRollNumber(String rollNumber) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_ROLL_NUMBER, Integer.class, new Object[]{rollNumber});
    }

    @Override
    public students findById(Integer id) {
        System.out.println(id);
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, studentRowMapper, new Object[]{id});
    }

    @Override
    public List<Map<String, Object>> GetAll() {
        List<Map<String, Object>> arr =  jdbcTemplate.queryForList("SELECT * FROM students");
        System.out.println("_+_+_+_+_+_+_+_+" + arr);
        return arr;
    }

    private RowMapper<students> studentRowMapper = ((rs, rowNum) -> {
        return new students(rs.getInt("id"), rs.getString("rollnumber"), null, rs.getString("name"));
    });
}
