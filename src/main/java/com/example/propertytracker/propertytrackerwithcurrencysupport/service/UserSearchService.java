package com.example.propertytracker.propertytrackerwithcurrencysupport.service;

import com.example.propertytracker.propertytrackerwithcurrencysupport.entity.User;
import com.example.propertytracker.propertytrackerwithcurrencysupport.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserSearchService {

    @Autowired
    private  UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }



}
