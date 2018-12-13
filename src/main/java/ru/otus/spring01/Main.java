package ru.otus.spring01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.spring01.config.QuizAppContext;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.service.CsvService;
import ru.otus.spring01.service.OutputService;
import ru.otus.spring01.service.QuizWrapperService;

import java.util.List;

@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        CsvService csvService = context.getBean(CsvService.class);
        QuizWrapperService quizWrapperService = context.getBean(QuizWrapperService.class);
        OutputService outputService = context.getBean(OutputService.class);

        String lang = outputService.getMessageInput("Select your language/Выберите ваш язык: [ru, en]");
        QuizAppContext.get().setLocale(lang);
        List<Question> questions = csvService.readCsv(Question.class, "quiz_" + QuizAppContext.get().getLocale().getLanguage().toLowerCase() + ".csv");

        Student student = quizWrapperService.createStudent();
        quizWrapperService.startQuiz(student, questions);
    }
}
