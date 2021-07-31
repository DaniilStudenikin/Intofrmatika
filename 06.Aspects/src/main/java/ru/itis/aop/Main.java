package ru.itis.aop;

import org.springframework.aop.framework.ProxyFactory;

public class Main {
    public static void main(String[] args) {
        FileAccessor target = new FileAccessor();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new BeforeOpenFile());

        FileAccessor proxied = (FileAccessor) proxyFactory.getProxy();
        proxied.openFile("input.txt");
    }
}
