package com.example.kkm_back.Controller;

import com.example.kkm_back.Domain.User;
import com.example.kkm_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String userTest() {
        User userA = new User(2, "testA", 2, "testA.com", "testA@test.com");
        User userB = new User(3, "testB", 3, "testB.com", "testB@test.com");

        userRepository.insertUser(userA);
        userRepository.insertXml(userB);

        return "OK";
    }
}
