package org.example.studentmanagement.service;

import org.example.studentmanagement.entity.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> findAll();

    void addLesson(Lesson lesson);

    void deleteById(int id);
}
