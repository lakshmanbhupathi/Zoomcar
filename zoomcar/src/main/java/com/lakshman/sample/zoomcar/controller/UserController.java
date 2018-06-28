package com.lakshman.sample.zoomcar.controller;

import com.lakshman.sample.zoomcar.dao.UserRepository;
import com.lakshman.sample.zoomcar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    /**
     * testing purpose
     * @return
     */
    @PostMapping("/addUsers")
    public boolean addDefaultUsers() {
        userRepository.save(new User("Lucky"));
        userRepository.save(new User("Dur"));
        userRepository.save(new User("Dev"));
        userRepository.save(new User("Sas"));

        return true;
    }

}
