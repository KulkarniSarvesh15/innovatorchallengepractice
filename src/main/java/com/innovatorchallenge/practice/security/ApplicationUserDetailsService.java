package com.innovatorchallenge.practice.security;

import com.innovatorchallenge.practice.model.User;
import com.innovatorchallenge.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user = userRepository.findByUserName(username);
        User user = userRepository.findByUserName(Long.parseLong(username));
        return new UserDetailsImplementation(user);
    }
}
