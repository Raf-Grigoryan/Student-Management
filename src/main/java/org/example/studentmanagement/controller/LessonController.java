package org.example.studentmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.studentmanagement.entity.Lesson;
import org.example.studentmanagement.service.LessonService;
import org.example.studentmanagement.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    private final TeacherService teacherService;

    @GetMapping()
    public String getLessonsPage(ModelMap modelMap) {
        modelMap.addAttribute("lessons", lessonService.findAll());
        return "/lesson/lesson";
    }

    @GetMapping("/add")
    public String lessonAddPage(ModelMap modelMap) {
        modelMap.addAttribute("teachers", teacherService.allTeachers());
        return "/lesson/addLesson";
    }

    @PostMapping("/add")
    public String lessonAdd(Lesson lesson) {
        lessonService.addLesson(lesson);
        return "redirect:/lesson";
    }

    @GetMapping("/delete")
    public String lessonDelete(@RequestParam("id") int lessonId) {
        lessonService.deleteById(lessonId);
        return "redirect:/lesson";
    }
}
