package com.example.propertytracker.propertytrackerwithcurrencysupport.controller;


import com.example.propertytracker.propertytrackerwithcurrencysupport.client.CreatePropertyRequest;
import com.example.propertytracker.propertytrackerwithcurrencysupport.entity.Property;
import com.example.propertytracker.propertytrackerwithcurrencysupport.service.PropertyAdminService;
import com.example.propertytracker.propertytrackerwithcurrencysupport.service.PropertySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
@CrossOrigin(origins = "http://localhost:9002")
public class PropertySearchController {

    @Autowired
    private PropertySearchService propertySearchService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Property>> getPropertiesByUser(@PathVariable String userId) {
        List<Property> properties = propertySearchService.getPropertiesByUser(userId);
        return ResponseEntity.ok(properties);
    }









}
