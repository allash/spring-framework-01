package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring01.dao.StudentDao;
import ru.otus.spring01.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    @Autowired
    public StudentServiceImpl(StudentDao dao) {
        this.dao = dao;
    }

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    public Student createStudent(String firstName, String lastName) {
        return dao.createStudent(firstName, lastName);
    }
}
