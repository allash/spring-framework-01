package ru.otus.spring01.dao;

import ru.otus.spring01.domain.Question;

import java.util.HashMap;
import java.util.Map;

public class QuizDaoImpl implements QuizDao {

    private Map<Question, String> questions = new HashMap<Question, String>();

    public void saveAnswer(Question question, String answer) {
        questions.put(question, answer);
    }

    public Map<Question, String> findAnswers() {
        return questions;
    }
}
