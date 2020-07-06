package com.example.schoolManagement.core;

import com.example.schoolManagement.model.Teacher;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/school/teacher")
@RestController
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }


    @GetMapping
    public Iterable<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }


    @DeleteMapping(path="{id}")
    public void deleteTeacherByID(@PathVariable("id") Integer id){
        teacherService.deleteTeacherByID(id);
    }

    @GetMapping(path="{id}")
    public Teacher getTeacherByID(@PathVariable("id") Integer id){
        return teacherService.getTeacherByID(id);
    }


    @PutMapping(path="{id}")
    public int updateTeacherByID(@PathVariable("id") Integer id, @RequestBody Teacher teacher){
        return teacherService.updateTeacherByID(id, teacher);
    }

}
