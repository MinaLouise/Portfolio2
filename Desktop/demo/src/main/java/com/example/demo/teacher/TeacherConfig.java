package com.example.demo.teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TeacherConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            TeacherRepository repository){
        return args -> {
            Teacher trinity = new Teacher(
                    "Trinity",
                    "Trin.jackson@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Teacher mark = new Teacher(
                    "Mark",
                    "mark@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5)
            );

            repository.saveAll(
                    List.of(trinity, mark)
            );
        };

    }
}
