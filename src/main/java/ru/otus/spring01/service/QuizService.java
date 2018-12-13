package ru.otus.spring01.service;

import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.QuizResult;

import java.util.Map;

public interface QuizService {

    void saveAnswer(Question question, String answer);

    QuizResult calculateResult();

    Map<Question, String> getAllAnswers();
}