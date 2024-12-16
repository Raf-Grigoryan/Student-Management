package org.example.studentmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.studentmanagement.entity.User;
import org.example.studentmanagement.entity.UserType;
import org.example.studentmanagement.repository.UserRepository;
import org.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final UserRepository userRepository;

    @Value("${student.management.image.upload.path}")
    private String filePath;

    @Override
    public List<User> allStudents() {
        return userRepository.getUserByUserType(UserType.STUDENT);
    }

    @SneakyThrows
    @Override
    public void addStudent(User student, MultipartFile imageFile) {
        String fileName;
        if (!imageFile.isEmpty()) {
            fileName = System.currentTimeMillis() + imageFile.getOriginalFilename();
            File file = new File(filePath, fileName);
            imageFile.transferTo(file);
            student.setImageName(fileName);
        } else {
            student.setImageName("default.jpeg");
        }
        student.setUserType(UserType.STUDENT);
        userRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        userRepository.deleteById(id);
    }
}
