package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.springbootdemo.dto.CourseDto;
import ru.itis.springbootdemo.repositories.CoursesRepository;
import ru.itis.springbootdemo.repositories.LessonRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;

import static ru.itis.springbootdemo.dto.CourseDto.*;

import java.util.List;

@RestController
public class EducationController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping("/courses/byLessonId")
    public List<CourseDto> getCoursesByLessonId(@RequestParam("lesson_id") Long lessonId) {
//        Lesson lesson = lessonRepository.getOne(lessonId);
//        return from(coursesRepository.findAllByLessonsContains(lesson));
        return from(coursesRepository.findByLessonId(lessonId));
    }

    @GetMapping("/courses/byCourseId")
    public List<CourseDto> getCourseByTeacherId(@RequestParam("teacherId") Long teacherId){
        return from(coursesRepository.findAllByTeacher_Id(teacherId));
    }
}
