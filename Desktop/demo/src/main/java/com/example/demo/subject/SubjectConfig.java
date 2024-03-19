package com.example.demo.subject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class SubjectConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            SubjectRepository repository){
        return args -> {
            Subject math = new Subject(
                    "Math"
            );

            Subject english = new Subject(
                    "English"
            );

            repository.saveAll(
                    List.of(math, english)
            );
        };

    }
}
