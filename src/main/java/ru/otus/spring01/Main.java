package ru.otus.spring01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.spring01.service.QuizWrapperService;

@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuizWrapperService quizWrapperService = context.getBean(QuizWrapperService.class);

        quizWrapperService.startQuiz();
    }
}
