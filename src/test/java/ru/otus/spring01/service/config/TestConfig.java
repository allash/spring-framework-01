package ru.otus.spring01.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application-test.properties")
@Configuration
public class TestConfig {

    @Value("${user.locale}")
    private String userLocale;
}
