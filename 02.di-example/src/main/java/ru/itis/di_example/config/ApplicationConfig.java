package ru.itis.di_example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.di_example.services.RandomNumbersService;
import ru.itis.di_example.services.RandomNumbersWithRangeService;

import java.util.Random;

@Configuration
public class ApplicationConfig {
    @Bean
    public RandomNumbersService randomNumbersWithRangeService() {
        return new RandomNumbersWithRangeService(100);
    }
    @Bean
    public Random random() {
        return new Random();
    }
}
