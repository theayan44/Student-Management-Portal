package com.example.studentmanagementportal;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentRepository {
    HashMap<Integer, Student> hm = new HashMap<>();

    public String addStudent(int admNo, Student student) {
        if(hm.containsKey(admNo))
            return null;
        hm.put(admNo, student);
        return "Student Added Successfully\n" + hm.get(admNo);
    }

    public Student getStudentDetails(int admNo) {
        return hm.get(admNo);
    }

    public String deleteStudent(int admNo) {
        if(hm.containsKey(admNo)){
            return "Student deleted successfully\n" + hm.remove(admNo);
        }
        return null;
    }

    public String updateCourse(int admNo, String course) {
        if(!hm.containsKey(admNo))
            return null;
        hm.get(admNo).setCourse(course);
        return "Course Updated Successfully\n" + hm.get(admNo);
    }

    public int numberOfStudents(int k) {
        int count = 0;
        for(int key : hm.keySet()){
            if(hm.get(key).getAge() > k)
                count++;
        }
        return count;
    }
}
