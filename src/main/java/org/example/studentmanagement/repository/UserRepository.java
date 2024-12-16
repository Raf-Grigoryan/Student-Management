package org.example.studentmanagement.repository;

import org.example.studentmanagement.entity.User;
import org.example.studentmanagement.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> getUserByUserType(UserType userType);

}
