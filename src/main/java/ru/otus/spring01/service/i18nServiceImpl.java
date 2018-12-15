package ru.otus.spring01.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring01.config.AppProps;

@Service
public class i18nServiceImpl implements i18nService {

    private MessageSource messageSource;
    private AppProps appProps;

    public i18nServiceImpl(MessageSource messageSource, AppProps appProps) {
        this.messageSource = messageSource;
        this.appProps = appProps;
    }

    public String getMessage(String messageId) {
        return messageSource.getMessage(messageId, null, appProps.getLocale()).trim();
    }
}
