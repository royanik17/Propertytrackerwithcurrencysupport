package com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti;

import lombok.Data;

@Data
public class NotificationSettings {
    private boolean emailAlerts;
    private boolean monthlySummary;
    private boolean lowBalanceAlert;
}
