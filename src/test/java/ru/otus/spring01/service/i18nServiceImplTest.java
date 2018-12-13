package ru.otus.spring01.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring01.Main;
import ru.otus.spring01.config.QuizAppContext;
import ru.otus.spring01.enums.MessageKeyEnum;

import static org.junit.Assert.assertEquals;

public class i18nServiceImplTest {

    private i18nService i18nService;

    @Before
    public void setUp() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        i18nService = context.getBean(i18nService.class);
    }

    @Test
    public void canCorrectlyTranslateMessage() {

        QuizAppContext.get().setLocale("ru");
        String russian = i18nService.getMessage(MessageKeyEnum.INVALID.toString());
        assertEquals(russian, "Неверно");

        QuizAppContext.get().setLocale("en");
        String english = i18nService.getMessage(MessageKeyEnum.INVALID.toString());
        assertEquals(english, "Invalid");
    }
}
