package com.innovatorchallenge.practice.util;

import com.innovatorchallenge.practice.controller.UserController;
import com.innovatorchallenge.practice.model.Role;
import com.innovatorchallenge.practice.model.User;
import com.innovatorchallenge.practice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserController userController;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role adminRole = new Role("Admin");
        Role userRole = new Role("User");
        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        User police = new User("Police","Police123");
        Role policeRole = roleRepository.findByName("Admin");
        police.setRoles(Collections.singleton(policeRole));
        userController.addUser(police);

        User citizen = new User("Citizen","Citizen123");
        Role citizenRole = roleRepository.findByName("User");
        citizen.setRoles(Collections.singleton(citizenRole));
        userController.addUser(citizen);
    }
}
