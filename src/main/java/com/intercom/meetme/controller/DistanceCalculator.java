package com.intercom.meetme.controller;

import com.intercom.meetme.model.Customer;

import java.lang.*;

public class DistanceCalculator {

    public static final double OFFICE_LATITUDE = 53.339428;
    public static final double OFFICE_LONGITUDE = -6.257664;

    static double distance(double latitude1, double longitude1, double latitude2, double longitude2, String unit) {
        double theta = longitude1 - longitude2;
        double dist = Math.sin(deg2rad(latitude1)) * Math.sin(deg2rad(latitude2)) + Math.cos(deg2rad(latitude1)) * Math.cos(deg2rad(latitude2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if ("K".equals(unit)) {
            dist = dist * 1.609344;
        } else if ("N".equals(unit)) {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    public static double distanceToDublinOffice(Customer customer) {
        return distance(customer.getLatitude(), customer.getLongitude(), OFFICE_LATITUDE, OFFICE_LONGITUDE, "K");
    }

}