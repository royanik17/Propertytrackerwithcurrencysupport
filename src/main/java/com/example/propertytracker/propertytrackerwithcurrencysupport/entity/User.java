package com.example.propertytracker.propertytrackerwithcurrencysupport.entity;

import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.NotificationSettings;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Preferences;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Role;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("email")
    private String email;
    @Field("phone")
    private String phone;
    @Field("password")
    private String password;
    @Field("role")
    private Role role;
    @Field("preferences")
    private Preferences preferences;
    @Field("property_ids")
    private List<String> propertyIds;// References to Property documents
    @Field("created_at")
    private LocalDateTime createdAt;
    @Field("last_login")
    private LocalDateTime lastLogin;
    @Field("status")
    private Status status;
    @Field("notification_settings")
    private NotificationSettings notificationSettings;
}
