package com.groovil.restapi.Student.Services;

import com.groovil.restapi.Exceptions.EtAuthException;
import com.groovil.restapi.Student.students;
import java.util.*;

public interface studentService {
    students registerStudents(String name, String rollnumber) throws EtAuthException;
    List<Map<String, Object>> getAll() throws EtAuthException;
    students FindByID(int id) throws EtAuthException;
}
