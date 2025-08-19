package com.example.propertytracker.propertytrackerwithcurrencysupport.service;

import com.example.propertytracker.propertytrackerwithcurrencysupport.client.CreatePropertyRequest;
import com.example.propertytracker.propertytrackerwithcurrencysupport.client.UpdatePropertyRequest;
import com.example.propertytracker.propertytrackerwithcurrencysupport.entity.Property;
import com.example.propertytracker.propertytrackerwithcurrencysupport.propertyrepository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PropertyAdminService {
    @Autowired
    private PropertyRepository propertyRepository;

    public Property addProperty(CreatePropertyRequest request) {
        Property property = new Property();
        property.setUserId(request.getUserId());
        property.setName(request.getName());
        property.setLocation(request.getLocation());
        property.setAddress(request.getAddress());
        property.setAreaSqft(request.getAreaSqft());
        property.setType(request.getType());
        property.setOwnershipType(request.getOwnershipType());
        property.setRented(request.isRented());
        property.setPurchaseDate(request.getPurchaseDate());
        property.setCurrency(request.getCurrency());
        property.setNotes(request.getNotes());
        property.setCreatedAt(LocalDateTime.now());

        return propertyRepository.save(property);
    }

    public Property updateProperty(String propertyId, UpdatePropertyRequest request) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found with ID: " + propertyId));

        // Update all editable fields
        property.setUserId(request.getUserId()); // optional, only if you allow user reassignment
        property.setName(request.getName());
        property.setLocation(request.getLocation());
        property.setAddress(request.getAddress());
        property.setAreaSqft(request.getAreaSqft());
        property.setType(request.getType());
        property.setOwnershipType(request.getOwnershipType());
        property.setRented(request.isRented());
        property.setPurchaseDate(request.getPurchaseDate());
        property.setCurrency(request.getCurrency());
        property.setNotes(request.getNotes());
        property.setUpdatedAt(LocalDateTime.now());

        return propertyRepository.save(property);
    }


}
