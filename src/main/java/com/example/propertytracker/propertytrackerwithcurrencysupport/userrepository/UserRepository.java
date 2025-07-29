package com.example.propertytracker.propertytrackerwithcurrencysupport.userrepository;

import com.example.propertytracker.propertytrackerwithcurrencysupport.entity.User;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Role;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    List<User> findByRole(Role role);
    List<User> findByStatus(Status status);


}
