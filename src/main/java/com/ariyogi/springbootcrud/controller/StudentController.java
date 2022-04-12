package com.ariyogi.springbootcrud.controller;

import com.ariyogi.springbootcrud.model.Student;
import com.ariyogi.springbootcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.remote.SubjectDelegationPermission;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAll")
    public List<Student> list(){
        return studentService.ListAll();
    }

    @PostMapping("/add")
    public  String add(@RequestBody Student student){
        studentService.save(student);
        return  "New Student Added";

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id){

        try{
            Student student = studentService.get(id);
            return new ResponseEntity<Student>(student,HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Integer id){

        try{
            Student existingStudend=studentService.get(id);
            studentService.save(student);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return  new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Integer id){

        studentService.delete(id);
        return "Delete Student With"+id;
    }

}
