package com.anuscode.user;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Business logic is written in service class

@Service // this will instantiate this UserService class i.e convert it into spring bean
public class UserService {

    public List<User> getUsers(){
        return List.of(
                new User(
                        1L,
                        "Mariam",
                        "Nothing",
                        "Home",
                        LocalDate.of(2000,Month.JANUARY,5),
                        true
                )
        );
    }
}
