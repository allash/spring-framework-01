package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Autowired
    public QuizWrapperServiceImpl(
            QuizService quizService,
            OutputService outputService,
            StudentService studentService,
            i18nService i18nService) {
        this.quizService = quizService;
        this.outputService = outputService;
        this.studentService = studentService;
        this.i18nService = i18nService;
    }

    public Student createStudent() {

        String firstName = outputService.getMessageInput(i18nService.getMessage(MessageKeyEnum.ENTER_FIRST_NAME.toString()));
        String lastName = outputService.getMessageInput(i18nService.getMessage(MessageKeyEnum.ENTER_LAST_NAME.toString()));

        return studentService.createStudent(firstName, lastName);
    }

    public void startQuiz(Student student, List<Question> questions) {

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