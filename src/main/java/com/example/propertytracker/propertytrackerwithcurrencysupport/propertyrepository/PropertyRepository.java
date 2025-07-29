package com.example.propertytracker.propertytrackerwithcurrencysupport.propertyrepository;

import com.example.propertytracker.propertytrackerwithcurrencysupport.entity.Property;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PropertyRepository extends MongoRepository<Property,String> {

    List<Property> findByUserId(String userId);

}
