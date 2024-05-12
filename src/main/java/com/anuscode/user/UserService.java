package com.anuscode.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Business logic is written in service class

@Service // this will instantiate this UserService class i.e convert it into spring bean
public class UserService {

    private final UserRepository  userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
       return userRepository.findAll();
    }
}
