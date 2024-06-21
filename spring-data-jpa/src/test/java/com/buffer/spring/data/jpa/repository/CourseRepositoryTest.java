package com.buffer.spring.data.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.buffer.spring.data.jpa.entity.Course;
import com.buffer.spring.data.jpa.entity.Student;
import com.buffer.spring.data.jpa.entity.Teacher;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    
    @Test
    public void printCourses() {
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("courses.0 = " + courses.size());
        System.out.println("courses.0.to = " + courses.toString());
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Priyanka");
        teacher.setLastName("Singh");
                

        Course course = new Course();
        course.setTitle("Python");
        course.setCredit(6);
        course.setTeacher(teacher);

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = 
                PageRequest.of(1,2);
        
        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalElements();

        long totalPages =
                courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("totalPages = " + totalPages);
        
        System.out.println("totalElements = " + totalElements);

        System.out.println("courses.1 = " + courses.size());
        
        System.out.println("courses.1.to = " + courses.toString());
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                        );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
                );
        
        List<Course> courses
                = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses.2 = " + courses.size());
        System.out.println("courses.2.to = " + courses.toString());
    }

    @Test
    public void printfindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "T",
                        firstPageTenRecords).getContent();

        System.out.println("courses.3 = " + courses.size());
        System.out.println("courses.3.to = " + courses.toString());
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = new Teacher();
        		teacher.setFirstName("Lizze1");
        		teacher.setLastName("Morgan1");

        Student student = new Student();
        student.setFirstName("Abhishek1");
        student.setLastName("Singh1");
        student.setEmailId("abhishek1@gmail.com");

        Course course = new Course();
        course.setTitle("AI1");
        course.setCredit(12);
        course.setTeacher(teacher);
        

        course.addStudents(student);

        courseRepository.save(course);
    }
}
