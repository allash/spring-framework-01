package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class OutputServiceImpl implements OutputService {

    private Scanner scanner;
    private i18nService i18nService;

    @Autowired
    public OutputServiceImpl(i18nService i18nService) {
        this.i18nService = i18nService;
        this.scanner = new Scanner(System.in);
    }

    public String getMessageInput(String message) {
        System.out.println(message);
        return scanner.next();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
