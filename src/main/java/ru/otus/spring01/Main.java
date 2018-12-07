package ru.otus.spring01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.QuizResult;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.service.CsvService;
import ru.otus.spring01.service.QuizService;
import ru.otus.spring01.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static String FILE_NAME = "quiz.csv";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        CsvService csvService = context.getBean(CsvService.class);
        StudentService studentService = context.getBean(StudentService.class);
        QuizService quizService = context.getBean(QuizService.class);

        System.out.println("Enter your first name: ");
        String firstName = scanner.next();

        System.out.println("Enter your last name: ");
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
        System.out.println("Correct: " + quizResult.getCorrectAnswerCount() + ". Invalid: " + quizResult.getInvalidAnswerCount());
    }
}
