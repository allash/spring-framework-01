package ru.otus.spring01.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring01.config.QuizAppContext;

@Service
public class i18nServiceImpl implements i18nService {

    private MessageSource messageSource;

    public i18nServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String messageId) {
        return messageSource.getMessage(messageId, null, QuizAppContext.get().getLocale());
    }
}
