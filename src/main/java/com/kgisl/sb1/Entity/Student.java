package com.kgisl.sb1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long phno;

    
    public Student() {
    }
    public Student(long id, String name, long phno) {
        this.id = id;
        this.name = name;
        this.phno = phno;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPhno() {
        return phno;
    }
    public void setPhno(long phno) {
        this.phno = phno;
    }

    


}
