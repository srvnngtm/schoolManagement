package com.example.schoolManagement.persistence;

import com.example.schoolManagement.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mysqlTeacher")
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
