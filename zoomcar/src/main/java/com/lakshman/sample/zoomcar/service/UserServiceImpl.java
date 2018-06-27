package com.lakshman.sample.zoomcar.service;

import com.lakshman.sample.zoomcar.dao.UserRepository;
import com.lakshman.sample.zoomcar.entity.User;
import com.lakshman.sample.zoomcar.exceptions.ContentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(final Long userId) {
        User user;
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            throw new ContentNotFoundException("User not found");
        }
        return user;
    }
}
