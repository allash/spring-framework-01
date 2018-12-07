package ru.otus.spring01.service;

import ru.otus.spring01.dao.StudentDao;
import ru.otus.spring01.domain.Student;

public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    public Student createStudent(String firstName, String lastName) {
        return dao.createStudent(firstName, lastName);
    }
}
