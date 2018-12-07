package ru.otus.spring01.dao;

import ru.otus.spring01.domain.Question;

import java.util.Map;

public interface QuizDao {

    void saveAnswer(Question question, String answer);
    Map<Question, String> findAnswers();
}
