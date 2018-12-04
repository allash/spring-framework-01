package ru.otus.spring01.service;

import ru.otus.spring01.dao.QuizDao;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.QuizResult;

import java.util.Map;

public class QuizServiceImpl implements QuizService {

    private QuizDao dao;

    public void setDao(QuizDao dao) {
        this.dao = dao;
    }

    public void saveAnswer(Question question, String answer) {
        dao.saveAnswer(question, answer);
    }

    public QuizResult calculateResult() {

        Map<Question, String> answers = this.dao.findAnswers();

        int correctAnswer = 0;
        int invalidAnswer = 0;

        for (Map.Entry<Question, String> entry : answers.entrySet()) {
            if (entry.getKey().getAnswer().equals(entry.getValue())) correctAnswer++;
            else invalidAnswer++;
        }

        return new QuizResult(correctAnswer, invalidAnswer);
    }

    public Map<Question, String> getAllAnswers() {
        return this.dao.findAnswers();
    }
}
