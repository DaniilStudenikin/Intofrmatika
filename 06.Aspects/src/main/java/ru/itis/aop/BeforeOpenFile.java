package ru.itis.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeOpenFile implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Целевой объект - " + target);
        FileAccessor accessor = (FileAccessor) target;
        System.out.println("Файл был открыт в " + accessor.getLastFileOpenTime());
    }
}
