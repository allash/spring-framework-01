package ru.otus.spring01.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class i18nServiceImpl implements i18nService {

    private MessageSource messageSource;
    private String locale;

    public i18nServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String messageId, String locale) {
        return messageSource.getMessage(messageId, null, getLocale(locale));
    }

    private Locale getLocale(String locale) {
        if (locale != null && locale.equals("ru")) return new Locale("ru", "RU");
        return Locale.getDefault();
    }
}
