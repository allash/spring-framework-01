package ru.otus.spring01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.spring01.config.QuizAppContext;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.service.CsvService;
import ru.otus.spring01.service.QuizWrapperService;

import java.util.List;
import java.util.Scanner;

@ComponentScan
public class Main {

    private static String FILE_NAME = "quiz.csv";

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        CsvService csvService = context.getBean(CsvService.class);
        QuizWrapperService quizWrapperService = context.getBean(QuizWrapperService.class);
        List<Question> questions = csvService.readCsv(Question.class, FILE_NAME);

        System.out.println("Select your language/Выберите ваш язык: [ru, en]");
        Scanner scanner = new Scanner(System.in);
        QuizAppContext.get().setLocale(scanner.next());

        Student student = quizWrapperService.createStudent();
        quizWrapperService.startQuiz(student, questions);
    }
}
