package org.example.studentmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.studentmanagement.entity.User;
import org.example.studentmanagement.service.LessonService;
import org.example.studentmanagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    private final LessonService lessonService;

    @GetMapping()
    public String student(ModelMap modelMap) {
        modelMap.put("students", studentService.allStudents());
        return "/student/student";
    }

    @GetMapping("/add")
    public String addStudentPage(ModelMap modelMap) {
        modelMap.put("lessons", lessonService.findAll());
        return "/student/addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute User student, @RequestParam("image") MultipartFile multipartFile) {
        studentService.addStudent(student, multipartFile);
        return "redirect:/student";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam int id) {
        studentService.deleteStudent(id);
        return "redirect:/student";
    }

}
