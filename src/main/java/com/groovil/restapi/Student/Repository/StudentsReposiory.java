package com.groovil.restapi.Student.Repository;

import java.util.*;

import com.groovil.restapi.Exceptions.EtAuthException;
import com.groovil.restapi.Student.students;

public interface StudentsReposiory {
    Integer create(String Name, String rollNumber) throws EtAuthException;
    // students findByRollNumber(String rollNumber) throws EtAuthException;
    Integer getCountByRollNumber(String rollNumber);
    students findById(Integer id);
    List<Map<String, Object>> GetAll() throws EtAuthException;
}
