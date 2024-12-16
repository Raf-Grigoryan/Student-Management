package org.example.studentmanagement.service;

import org.example.studentmanagement.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {

    List<User> allStudents();

    void addStudent(User student, MultipartFile file);

    void deleteStudent(int id);
}
