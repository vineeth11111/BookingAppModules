package com.luv2code.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
