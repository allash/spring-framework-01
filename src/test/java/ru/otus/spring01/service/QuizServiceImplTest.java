package ru.otus.spring01.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.QuizResult;

import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class QuizServiceImplTest {

    private QuizService quizService;

    @Before
    public void setUp() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        quizService = context.getBean(QuizService.class);
    }

    @Test
    public void saveAnswer() {

        Question question1 = new Question(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        String answer1 = UUID.randomUUID().toString();

        Question question2 = new Question(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        String answer2 = UUID.randomUUID().toString();

        Question question3 = new Question(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        String answer3 = UUID.randomUUID().toString();

        quizService.saveAnswer(question1, answer1);
        quizService.saveAnswer(question2, answer2);
        quizService.saveAnswer(question3, answer3);

        Map<Question, String> answers = quizService.getAllAnswers();
        assertEquals(answers.size(), 3);

        assertEquals(answers.get(question1), answer1);
        assertEquals(answers.get(question2), answer2);
        assertEquals(answers.get(question3), answer3);
    }

    @Test
    public void calculateResult() {

        Question question1 = new Question(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        String invalidAnswer = UUID.randomUUID().toString();

        String validAnswer1 = UUID.randomUUID().toString();
        Question question2 = new Question(UUID.randomUUID().toString(), validAnswer1);

        String validAnswer2 = UUID.randomUUID().toString();
        Question question3 = new Question(UUID.randomUUID().toString(), validAnswer2);

        quizService.saveAnswer(question1, invalidAnswer);
        quizService.saveAnswer(question2, validAnswer1);
        quizService.saveAnswer(question3, validAnswer2);

        QuizResult quizResult = quizService.calculateResult();
        assertEquals(quizResult.getCorrectAnswerCount(), 2);
        assertEquals(quizResult.getInvalidAnswerCount(), 1);
    }
}