package com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti;

import lombok.Data;

@Data
public class Preferences {
    private String defaultCurrency;
    private String timezone;
    private String language;
}
