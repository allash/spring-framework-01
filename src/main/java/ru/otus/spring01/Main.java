package ru.otus.spring01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.spring01.config.AppConfig;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.QuizResult;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.service.CsvService;
import ru.otus.spring01.service.QuizService;
import ru.otus.spring01.service.StudentService;
import ru.otus.spring01.service.i18nService;

import java.util.List;
import java.util.Scanner;

@ComponentScan
public class Main {

    private static String FILE_NAME = "quiz.csv";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        CsvService csvService = context.getBean(CsvService.class);
        StudentService studentService = context.getBean(StudentService.class);
        QuizService quizService = context.getBean(QuizService.class);
        i18nService i18nService = context.getBean(i18nService.class);
        AppConfig appConfig = context.getBean(AppConfig.class);

        System.out.println(i18nService.getMessage("enter_first_name", appConfig.userLocale) + ":");
        String firstName = scanner.next();

        System.out.println(i18nService.getMessage("enter_last_name", appConfig.userLocale) + ":");
        String lastName = scanner.next();

        Student student = studentService.createStudent(firstName, lastName);

        List<Question> questions = csvService.readCsv(Question.class, FILE_NAME);

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            String answer = scanner.next();

            quizService.saveAnswer(question, answer);
        }

        QuizResult quizResult = quizService.calculateResult();

        System.out.println(student.getFirstName() + ", " + student.getLastName());
        System.out.println(i18nService.getMessage("correct", appConfig.userLocale) + ": " + quizResult.getCorrectAnswerCount());
        System.out.println(i18nService.getMessage("invalid", appConfig.userLocale) + ": " + quizResult.getInvalidAnswerCount());
    }
}
