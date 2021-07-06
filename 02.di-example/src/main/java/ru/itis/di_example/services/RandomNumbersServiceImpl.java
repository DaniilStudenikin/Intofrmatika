package ru.itis.di_example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("randomNumberService")
public class RandomNumbersServiceImpl implements RandomNumbersService {
    @Autowired
    private Random random;

    @Override
    public int random() {
        return random.nextInt();
    }
}
