package com.example.studentmanagementportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {
        int admNo = student.getAdmNo();
        return studentRepository.addStudent(admNo, student);
    }

    public Student getStudentDetails(int admNo) {
        return studentRepository.getStudentDetails(admNo);
    }

    public String deleteStudent(int admNo) {
        return studentRepository.deleteStudent(admNo);
    }

    public String  updateCourse(int admNo, String course) {
        return studentRepository.updateCourse(admNo, course);
    }

    public int numberOfStudents(int k) {
        return studentRepository.numberOfStudents(k);
    }
}
