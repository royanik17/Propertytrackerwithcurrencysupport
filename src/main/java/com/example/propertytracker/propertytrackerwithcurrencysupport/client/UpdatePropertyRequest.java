package com.example.propertytracker.propertytrackerwithcurrencysupport.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePropertyRequest {

    private String userId;


    private String name;


    private String location;


    private String address;


    private double areaSqft;


    private String type;


    private String ownershipType;

    private boolean isRented;


    private Date purchaseDate;


    private String currency;

    private String notes;
}
