package com.example.propertytracker.propertytrackerwithcurrencysupport.service;

import com.example.propertytracker.propertytrackerwithcurrencysupport.client.CreatePropertyRequest;
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

}
