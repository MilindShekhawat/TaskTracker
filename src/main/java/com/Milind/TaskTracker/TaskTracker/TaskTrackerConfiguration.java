package com.Milind.TaskTracker.TaskTracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//Class to generate default values in table as  hibernate.ddlauto is set to create-drop
@Configuration
public class TaskTrackerConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(TaskTrackerRepository repository) {
        return args -> {
            TaskTracker drink = new TaskTracker(
                    "T1",
                    "Drink",
                    "Drink water",
                    LocalDate.of(2023, Month.AUGUST, 9)
            );
            repository.saveAll(List.of(drink));
        };
    }
}
