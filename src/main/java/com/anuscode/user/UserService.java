package com.anuscode.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Business logic is written in service class

@Service // this will instantiate this UserService class i.e convert it into spring bean
public class UserService {

    private final UserRepository  userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // Get Api logic
    public List<User> getUsers(){
       return userRepository.findAll();
    }

    //Post Api logic
    public void addNewTodo(User user) {
        System.out.println("User in addNewTodo");
        System.out.println(user.toString());
        Optional<User> userOptional = userRepository.findUserByTitle(user.getTitle());
        if(userOptional.isPresent()){
            throw new IllegalStateException("title taken");
        }
       userRepository.save(user);
    }





}
