package com.intercom.meetme.controller;

import com.intercom.meetme.model.Customer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerFilter {

    public static List<Customer> filter(List<Customer> customers) {
        return customers.
            stream().
            filter(c -> DistanceCalculator.distanceToDublinOffice(c) <= 100).
            sorted(Comparator.comparing(Customer::getUserId)).
            collect(Collectors.toList());
    }

}
