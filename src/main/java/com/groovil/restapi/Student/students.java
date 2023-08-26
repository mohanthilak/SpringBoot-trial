package com.groovil.restapi.Student;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class students {
    @Id
    // @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id; 
    
    private String rollnumber;
    private Date dob;
    private String name;
    
    public students() {
    }

    public students(Integer id, String rollnumber, Date dob, String name) {
        this.id = id;
        this.rollnumber = rollnumber;
        this.dob = dob;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollnumber;
    }

    public void setRollNumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
