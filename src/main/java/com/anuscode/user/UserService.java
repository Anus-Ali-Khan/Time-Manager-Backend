package com.anuscode.user;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        Optional<User> userOptional = userRepository.findUserByTitle(user.getTitle());
        if(userOptional.isPresent()){
            throw new IllegalStateException("title taken");
        }
       userRepository.save(user);
    }

    public void deleteTodo(Long userId){
        boolean idExists = userRepository.existsById(userId);
        if(!idExists){
            throw new IllegalStateException("Todo with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateTodo(Long userId, String title, String description){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("todo with id " + userId + " does not exist"));

        if(title != null &&
                title.length() > 0 &&
                !Objects.equals(user.getTitle(), title)){
            Optional<User> userOptional = userRepository.findUserByTitle(title);
            if(userOptional.isPresent()){
                throw new IllegalStateException("title taken");
            }
            user.setTitle(title);
        }

        if(description != null && description.length() > 0 && !Objects.equals(user.getDescription(), description)){
            user.setDescription(description);
        }
    }





}
