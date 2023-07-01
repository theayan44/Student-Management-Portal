package com.example.studentmanagementportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    //Add Students
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String s = studentService.addStudent(student);
        if(s != null)
            return new ResponseEntity(s, HttpStatus.CREATED);
        else
            return new ResponseEntity("Student with same Admission number is already exists", HttpStatus.BAD_REQUEST);
    }

    //Get Student Details
    @GetMapping("/get_info")
    public ResponseEntity getStudentDetails(@RequestParam("id") int admNo){
        Student s = studentService.getStudentDetails(admNo);
        if(s != null)
            return new ResponseEntity(s, HttpStatus.FOUND);
        else
            return new ResponseEntity("Admission number not found", HttpStatus.NOT_FOUND);
    }

    //Delete Student
    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int admNo){
        String s = studentService.deleteStudent(admNo);
        if(s != null)
            return new ResponseEntity(s, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity("Admission number doesn't exists", HttpStatus.BAD_REQUEST);
    }

    //Update the course of a particular student
    @PutMapping("/update_course")
    public ResponseEntity updateCourse(@RequestParam("id") int admNo, @RequestParam("course") String course){
        String  s = studentService.updateCourse(admNo, course);
        if(s != null)
            return new ResponseEntity(s, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity("Admission number doesn't exists", HttpStatus.BAD_REQUEST);
    }

    //Get the number of students age > k
    @GetMapping("/students_count")
    public ResponseEntity numberOfStudents(@RequestParam("k") int k){
        int n = studentService.numberOfStudents(k);
        return new ResponseEntity(n, HttpStatus.ACCEPTED);
    }

}
