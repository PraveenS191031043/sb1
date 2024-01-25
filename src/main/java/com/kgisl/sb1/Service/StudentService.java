package com.kgisl.sb1.Service;

import com.kgisl.sb1.Entity.Student;
import com.kgisl.sb1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(long id, Student currentStudent) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(currentStudent.getName());
            student.setPhno(currentStudent.getPhno());
            return studentRepository.save(student);
        }
        return null;
    }

    public boolean deleteStudent(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
