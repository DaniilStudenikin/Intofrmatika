package ru.itis.aop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;

public class FileAccessor {

    private LocalDateTime lastFileOpenTime;

    public LocalDateTime getLastFileOpenTime() {
        return lastFileOpenTime;
    }

    public InputStream openFile(String fileName) {
        try {
            lastFileOpenTime = LocalDateTime.now();
            return new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
            return null;
        }
    }
}
