package com.kgisl.sb1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgisl.sb1.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}