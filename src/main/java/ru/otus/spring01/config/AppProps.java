package ru.otus.spring01.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@PropertySource("classpath:application.properties")
@Component
public class AppProps {

    @Value("${user.languageTag}")
    public String languageTag;

    public Locale getLocale() {
        return Locale.forLanguageTag(languageTag);
    }

    public String getQuestionsCsvFileNameByPrefix(String prefix) {
        return prefix + "_" + getLocale().getLanguage() + ".csv";
    }
}
