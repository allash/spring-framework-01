package ru.otus.spring01.dao;

import ru.otus.spring01.domain.Student;

public interface StudentDao {
    Student createStudent(String firstName, String lastName);
}
