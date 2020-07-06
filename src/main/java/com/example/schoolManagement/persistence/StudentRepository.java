package com.example.schoolManagement.persistence;

import com.example.schoolManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("mysql")
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
