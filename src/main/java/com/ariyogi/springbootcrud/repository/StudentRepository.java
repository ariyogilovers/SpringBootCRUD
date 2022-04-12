package com.ariyogi.springbootcrud.repository;

import com.ariyogi.springbootcrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {


}
