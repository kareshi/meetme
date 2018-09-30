package com.intercom.meetme.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class CustomersFactory {

    private static Gson gson = new GsonBuilder().create();

    public static List<Customer> buildCustomers(List<String> lines) {
        List<Customer> customers = new ArrayList<>();
        for(String line : lines) {
            customers.add(buildCustomer(line));
        }
        return customers;
    }

    static Customer buildCustomer(String line) {
        return gson.fromJson(line, Customer.class);
    }

}

