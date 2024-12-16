package org.example.studentmanagement.service;

import org.example.studentmanagement.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TeacherService {

    void addTeacher(User user, MultipartFile file);

    List<User> allTeachers();

    void deleteTeacher(int id);

}
