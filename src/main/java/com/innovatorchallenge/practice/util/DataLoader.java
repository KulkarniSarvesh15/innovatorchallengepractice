package com.innovatorchallenge.practice.util;

import com.innovatorchallenge.practice.controller.UserController;
import com.innovatorchallenge.practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserController userController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("Police","Police123");
        userController.addUser(user);
    }
}
