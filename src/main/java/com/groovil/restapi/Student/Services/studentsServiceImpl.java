package com.groovil.restapi.Student.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groovil.restapi.Exceptions.EtAuthException;
import com.groovil.restapi.Student.students;
import com.groovil.restapi.Student.Repository.StudentsReposiory;

import jakarta.transaction.Transactional;

import java.util.*;

@Service
@Transactional
public class studentsServiceImpl implements studentService{
    
    @Autowired
    StudentsReposiory studentsRepository;

    @Override 
    public students registerStudents(String name, String rollnumber) throws EtAuthException{
        try{
            Integer count = studentsRepository.getCountByRollNumber(rollnumber);
            if(count > 0)
            throw new EtAuthException("RollNumber already in use");
            Integer userId = studentsRepository.create(name, rollnumber);
            System.out.println("userId: " + userId);
            students s = studentsRepository.findById(userId); 
            System.out.println(s.getName());
            return s;
        }catch(Exception e) {
            System.out.println("Service layer error");
            throw new EtAuthException("Invalid details. Failed to create a new student At service layer" + e);
        }
    }

    @Override
    public List<Map<String, Object>> getAll() throws EtAuthException {
        return studentsRepository.GetAll();
    }

    @Override 
    public students FindByID(int id) {
        return studentsRepository.findById(id);
    }
}
