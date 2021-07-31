package ru.itis.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileAccessor {
    public InputStream openFile(String fileName) {
        try {
            return new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
            return null;
        }
    }
}
