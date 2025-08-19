package com.example.propertytracker.propertytrackerwithcurrencysupport.service;

import com.example.propertytracker.propertytrackerwithcurrencysupport.entity.Property;
import com.example.propertytracker.propertytrackerwithcurrencysupport.propertyrepository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertySearchService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getPropertiesByUser(String userId) {
        return propertyRepository.findByUserId(userId);
    }

    public Property getPropertyById(String id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public void deleteProperty(String id) {
        propertyRepository.deleteById(id);
    }


}
