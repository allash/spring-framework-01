package ru.otus.spring01.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring01.domain.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

    public Student createStudent(String firstName, String lastName) {
        return new Student(firstName, lastName);
    }
}
