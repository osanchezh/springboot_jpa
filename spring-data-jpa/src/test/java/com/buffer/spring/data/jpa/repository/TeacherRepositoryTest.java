package com.buffer.spring.data.jpa.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.buffer.spring.data.jpa.entity.Course;
import com.buffer.spring.data.jpa.entity.Teacher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseDBA = new Course();
        courseDBA.setTitle("DBA");
        courseDBA.setCredit(5);

        Course courseJava = new Course();
        courseJava.setTitle("Java");
        courseJava.setCredit(6);

        Teacher teacher =
                new Teacher();
        teacher.setFirstName("Qutub");
        teacher.setLastName("Khan");
        
        teacher.setCourses(List.of(courseDBA,courseJava));

        teacherRepository.save(teacher);
    }
}