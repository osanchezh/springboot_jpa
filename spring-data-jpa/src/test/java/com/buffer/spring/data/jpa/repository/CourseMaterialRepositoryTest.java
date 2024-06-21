package com.buffer.spring.data.jpa.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.buffer.spring.data.jpa.entity.Course;
import com.buffer.spring.data.jpa.entity.CourseMaterial;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial() {
        Course course =
                new Course();
        course.setTitle(".net");
                course.setCredit(6);


        CourseMaterial courseMaterial =
                new CourseMaterial();
        courseMaterial.setUrl("www.dailycodebuffer.com");
        courseMaterial.setCourse(course);
                

        repository.save(courseMaterial);
    }
    
    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = 
                repository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }
}