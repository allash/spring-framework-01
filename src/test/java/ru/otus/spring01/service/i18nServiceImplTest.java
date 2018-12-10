package ru.otus.spring01.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring01.Main;

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
        String russian = i18nService.getMessage("invalid", "ru");
        assertEquals(russian, "Неверно");
        String english = i18nService.getMessage("invalid", "en");
        assertEquals(english, "Invalid");
    }
}
