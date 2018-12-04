package ru.otus.spring01.service;

import ru.otus.spring01.domain.Student;

public interface StudentService {
    Student createStudent(String firstName, String lastName);
}
