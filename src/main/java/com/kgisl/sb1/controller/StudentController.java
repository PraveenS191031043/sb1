package com.kgisl.sb1.controller;

import com.kgisl.sb1.Entity.Student;
import com.kgisl.sb1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping(value = "/", headers = "Accept=application/json")
    public ResponseEntity<Student> createCustomer(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getEmployeeById(@PathVariable("id") long id) {
        Student student = studentService.getStudentById(id);
        
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            System.out.println("not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Student> updateEmployee(@PathVariable("id") long id, @RequestBody Student currentStudent) {
        Student updatedStudent = studentService.updateStudent(id, currentStudent);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            System.out.println("Not Found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Student> deleteCustomer(@PathVariable("id") long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            System.out.println("Not Found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
