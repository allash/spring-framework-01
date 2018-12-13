package ru.otus.spring01.config;

import java.util.Locale;

public class QuizAppContext {

    private static QuizAppContext _instance;
    private Locale locale;

    private QuizAppContext() { }

    public static synchronized QuizAppContext get() {
        if (_instance == null) {
            _instance = new QuizAppContext();
        }

        return _instance;
    }

    public void setLocale(String locale) {
        if (locale.equals("ru")) this.locale = new Locale("ru", "RU");
        else if (locale.equals("en")) this.locale = new Locale(Locale.US.getLanguage());
        else this.locale = Locale.getDefault();
    }

    public Locale getLocale() {
        return this.locale;
    }
}
