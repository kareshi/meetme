package com.intercom.meetme;

import com.intercom.meetme.controller.CustomerFilter;
import com.intercom.meetme.model.CustomersFactory;
import com.intercom.meetme.model.Customer;
import com.intercom.meetme.model.LineReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length < 1) {
            throw new IllegalArgumentException("Please specify filename");
        }
        File file = new File(args[0]);
        FileInputStream fileInputStream = new FileInputStream(file);
        List<String> jsons = LineReader.build(fileInputStream);
        List<Customer> customers = CustomersFactory.buildCustomers(jsons);
        List<Customer> result = CustomerFilter.filter(customers);
        for(Customer customer : result) {
            System.out.println(customer);
        }
    }

}
