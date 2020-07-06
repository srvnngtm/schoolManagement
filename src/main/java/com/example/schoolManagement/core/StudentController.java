package com.example.schoolManagement.core;

import com.example.schoolManagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/school/student")
@RestController
public class StudentController {

    private final StudentService studentService;
    private final TeacherService teacherService;
    @Autowired
    public StudentController(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }


    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }


    @GetMapping
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @DeleteMapping(path="{id}")
    public void deleteStudentByID(@PathVariable("id") Integer id){
        studentService.deleteStudentByID(id);
    }


    @GetMapping(path="{id}")
    public Student getStudentByID(@PathVariable("id") Integer id){
        return studentService.getStudentByID(id);
    }


    @PutMapping(path="{id}")
    public int updateStudentByID(@PathVariable("id") Integer id,@RequestBody Student student){
        return  studentService.updateStudentByID(id, student);
    }


}
