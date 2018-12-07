package ru.otus.spring01.service;

import java.util.List;

public interface CsvService {
    <T> List<T> readCsv(Class<T> type, String fileName);
}
