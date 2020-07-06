package com.example.schoolManagement.core;

import com.example.schoolManagement.model.Teacher;
import com.example.schoolManagement.persistence.TeacherRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(@Qualifier("mysqlTeacher") TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void addTeacher(Teacher teacher){
         teacherRepository.save(teacher);
    }

    public Iterable<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void deleteTeacherByID(Integer id){
        teacherRepository.deleteById(id);
    }


    public Teacher getTeacherByID(Integer id){
        return teacherRepository.findById(id).orElse(null);
    }


    public int updateTeacherByID(Integer id,Teacher teacher){
        Teacher toBeUpdated = teacherRepository.findById(id).orElse(null);
        if (toBeUpdated != null){
            toBeUpdated.setEmail(teacher.getEmail());
            toBeUpdated.setName(teacher.getName());
            teacherRepository.save(toBeUpdated);
            return 1;
        }
        return 0;
    }



}
