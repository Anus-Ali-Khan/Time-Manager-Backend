package com.anuscode.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired // this dependency will guide that from where to take UserService and inject instantiated object of UserService class to our variable(userService) declared.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET API
    @GetMapping
    public List<User> getTodos(){
        return userService.getUsers();
    }

//Post Api
    @PostMapping
    public void createNewTodo(@RequestBody User user){
        System.out.println("RequestBody user");
        System.out.println(user);
        userService.addNewTodo(user);
    }
}

