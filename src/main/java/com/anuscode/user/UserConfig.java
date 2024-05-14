package com.anuscode.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
           User mariam = new User(
//                    1L,
                    "Mariam",
                    "Nothing",
                    "Home",
                    LocalDate.of(2000, Month.JANUARY,5),
                    true,
                   LocalDate.of(2000,Month.JANUARY,5)
            );

            User alex = new User(
//                    2L,
                    "Alex",
                    "Nothing",
                    "Home",
                    LocalDate.of(2004, Month.JANUARY,5),
                    true,
                    LocalDate.of(2004,Month.JANUARY,5)
            );

            System.out.println("uyuyvyuv");
            System.out.println(LocalDate.of(2004, Month.JANUARY,5));

            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}
