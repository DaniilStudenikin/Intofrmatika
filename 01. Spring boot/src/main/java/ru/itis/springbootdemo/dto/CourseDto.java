package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.models.Course;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
    private Long id;
    private String name;

    public static CourseDto from(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .name(course.getName())
                .build();
    }

    public static List<CourseDto> from(List<Course> courses) {
        return courses.stream().map(CourseDto::from).collect(Collectors.toList());
    }
}
