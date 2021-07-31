package ru.itis.proxy;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        FileAccessor accessor = new FileAccessor();
        InputStream input = accessor.openFile("input.txt");
        FileAccessorProxy fileAccessorProxy = new FileAccessorProxy(accessor);
        fileAccessorProxy.setBefore(() -> System.out.println("Открытие файла"));
        fileAccessorProxy.setAfter(() -> System.out.println("Файл открыт"));

        FileAccessor proxied = fileAccessorProxy;

        //----

        proxied.openFile("input.txt");
    }
}
