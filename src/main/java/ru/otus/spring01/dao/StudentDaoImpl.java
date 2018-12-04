package ru.otus.spring01.dao;

import ru.otus.spring01.domain.Student;

public class StudentDaoImpl implements StudentDao {

    public Student createStudent(String firstName, String lastName) {
        return new Student(firstName, lastName);
    }
}
