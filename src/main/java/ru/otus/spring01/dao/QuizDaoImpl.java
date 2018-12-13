package ru.otus.spring01.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring01.domain.Question;

import java.util.HashMap;
import java.util.Map;

@Repository
public class QuizDaoImpl implements QuizDao {

    private Map<Question, String> questions = new HashMap<Question, String>();

    public void saveAnswer(Question question, String answer) {
        questions.put(question, answer);
    }

    public Map<Question, String> findAnswers() {
        return questions;
    }
}
