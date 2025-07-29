package com.example.propertytracker.propertytrackerwithcurrencysupport.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(collection = "properties")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Property {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("name")
    private String name;
    @Field("location")
    private String location;
    @Field("address")
    private String address;

    @Field("area_sqft")
    private double areaSqft;

    private String type;

    @Field("ownership_type")
    private String ownershipType;

    @Field("is_rented")
    private boolean isRented;

    @Field("purchase_date")
    private Date purchaseDate;

    private String currency;
    private String notes;

    @Field("created_at")
    private LocalDateTime createdAt;
}
