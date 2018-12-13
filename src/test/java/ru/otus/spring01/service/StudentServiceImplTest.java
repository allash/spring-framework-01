package ru.otus.spring01.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring01.Main;
import ru.otus.spring01.domain.Student;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class StudentServiceImplTest {

    private StudentService studentService;

    @Before
    public void setUp() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        studentService = context.getBean(StudentService.class);
    }

    @Test
    public void createStudent() {
        String firstName = UUID.randomUUID().toString();
        String lastName = UUID.randomUUID().toString();

        Student student = studentService.createStudent(firstName, lastName);

        assertEquals(student.getFirstName(), firstName);
        assertEquals(student.getLastName(), lastName);
    }
}