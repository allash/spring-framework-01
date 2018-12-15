package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring01.config.AppProps;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.QuizResult;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.enums.MessageKeyEnum;

import java.util.List;

@Service
public class QuizWrapperServiceImpl implements QuizWrapperService {

    private QuizService quizService;
    private OutputService outputService;
    private StudentService studentService;
    private i18nService i18nService;
    private CsvService csvService;
    private AppProps appProps;

    private static String FILE_PREFIX_NAME = "quiz";

    @Autowired
    public QuizWrapperServiceImpl(
            QuizService quizService,
            OutputService outputService,
            StudentService studentService,
            i18nService i18nService,
            CsvService csvService,
            AppProps appProps) {
        this.quizService = quizService;
        this.outputService = outputService;
        this.studentService = studentService;
        this.i18nService = i18nService;
        this.csvService = csvService;
        this.appProps = appProps;
    }

    private Student createStudent() {

        String firstName = outputService.getMessageInput(i18nService.getMessage(MessageKeyEnum.ENTER_FIRST_NAME.toString()));
        String lastName = outputService.getMessageInput(i18nService.getMessage(MessageKeyEnum.ENTER_LAST_NAME.toString()));

        return studentService.createStudent(firstName, lastName);
    }

    public void startQuiz() {

        Student student = createStudent();
        List<Question> questions = csvService.readCsv(Question.class, appProps.getQuestionsCsvFileNameByPrefix(FILE_PREFIX_NAME));

        for (Question question : questions) {
            String answer = outputService.getMessageInput(question.getQuestion());
            quizService.saveAnswer(question, answer);
        }

        QuizResult quizResult = quizService.calculateResult();

        outputService.printMessage(student.getFirstName() + ", " + student.getLastName());
        outputService.printMessage(i18nService.getMessage(MessageKeyEnum.CORRECT.toString()) + ": " + quizResult.getCorrectAnswerCount());
        outputService.printMessage(i18nService.getMessage(MessageKeyEnum.INVALID.toString()) + ": " + quizResult.getInvalidAnswerCount());
    }
}