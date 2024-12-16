package org.example.studentmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.studentmanagement.entity.User;
import org.example.studentmanagement.entity.UserType;
import org.example.studentmanagement.repository.UserRepository;
import org.example.studentmanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final UserRepository userRepository;

    @Value("${student.management.image.upload.path}")
    private String filePath;

    @SneakyThrows
    @Override
    public void addTeacher(User teacher, MultipartFile imageFile) {
        String fileName;
        if (!imageFile.isEmpty()) {
            fileName = System.currentTimeMillis() + imageFile.getOriginalFilename();
            File file = new File(filePath, fileName);
            imageFile.transferTo(file);
            teacher.setImageName(fileName);
        } else {
            teacher.setImageName("default.jpeg");
        }
        teacher.setUserType(UserType.TEACHER);
        userRepository.save(teacher);
    }

    @Override
    public List<User> allTeachers() {
        return userRepository.getUserByUserType(UserType.TEACHER);
    }

    @Override
    public void deleteTeacher(int id) {
        userRepository.deleteById(id);
    }
}
