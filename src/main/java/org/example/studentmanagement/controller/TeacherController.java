package org.example.studentmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.studentmanagement.entity.User;
import org.example.studentmanagement.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping()
    public String teacher(ModelMap model) {
        model.put("teachers", teacherService.allTeachers());
        return "/teacher/teacher";
    }

    @GetMapping("/add")
    public String addTeacher() {
        return "/teacher/addTeacher";
    }

    @PostMapping("/add")
    public String addTeacher(@ModelAttribute User teacher, @RequestParam("image") MultipartFile image) {
        teacherService.addTeacher(teacher, image);
        return "/teacher/teacher";
    }

    @GetMapping("/delete")
    public String deleteTeacher(@RequestParam("id") int id  ) {
        teacherService.deleteTeacher(id);
        return "/teacher/teacher";
    }

}
