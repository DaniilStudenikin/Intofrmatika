package ru.itis.di_example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

public class RandomNumbersWithRangeService implements RandomNumbersService {
    @Autowired
    private Random random;
    private int upper;

    public RandomNumbersWithRangeService(int upper) {
        this.upper = upper;
    }

    @Override
    public int random() {
        return random.nextInt(upper);
    }
}
