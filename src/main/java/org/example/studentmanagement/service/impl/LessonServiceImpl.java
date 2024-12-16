package org.example.studentmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.studentmanagement.entity.Lesson;
import org.example.studentmanagement.repository.LessonRepository;
import org.example.studentmanagement.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;


    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public void addLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public void deleteById(int id) {
        lessonRepository.deleteById(id);
    }
}
