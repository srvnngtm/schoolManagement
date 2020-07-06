package com.example.schoolManagement.core;

import com.example.schoolManagement.model.Student;
import com.example.schoolManagement.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(@Qualifier("mysql") StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }


    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void deleteStudentByID(Integer id){
        studentRepository.deleteById(id);
    }


    public Student getStudentByID(Integer id){
        return studentRepository.findById(id).orElse(null);
    }


    public int updateStudentByID(Integer id,Student student){
        Student toBeUpdated = studentRepository.findById(id).orElse(null);
        if (toBeUpdated != null){
            toBeUpdated.setEmail(student.getEmail());
            toBeUpdated.setName(student.getName());
            studentRepository.save(toBeUpdated);
            return 1;
        }
        return 0;
    }
}
