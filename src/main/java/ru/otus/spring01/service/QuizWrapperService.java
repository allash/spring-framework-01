package ru.otus.spring01.service;

import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Student;

import java.util.List;

public interface QuizWrapperService {
    Student createStudent();
    void startQuiz(Student student, List<Question> questions);
}
