package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
