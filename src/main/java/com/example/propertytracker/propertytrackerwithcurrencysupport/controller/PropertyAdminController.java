package com.example.propertytracker.propertytrackerwithcurrencysupport.controller;


import com.example.propertytracker.propertytrackerwithcurrencysupport.client.CreatePropertyRequest;
import com.example.propertytracker.propertytrackerwithcurrencysupport.client.UpdatePropertyRequest;
import com.example.propertytracker.propertytrackerwithcurrencysupport.entity.Property;
import com.example.propertytracker.propertytrackerwithcurrencysupport.service.PropertyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyAdminController {

    @Autowired
    private  PropertyAdminService propertyAdminService;

    @PostMapping
    public ResponseEntity<Property> addProperty(@RequestBody CreatePropertyRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(propertyAdminService.addProperty(request));
    }


    @PutMapping("/{propertyId}")
    public ResponseEntity<Property> updateProperty(
            @PathVariable String propertyId,
            @RequestBody UpdatePropertyRequest request) {

        Property updatedProperty = propertyAdminService.updateProperty(propertyId, request);
        return ResponseEntity.ok(updatedProperty);
    }




}
