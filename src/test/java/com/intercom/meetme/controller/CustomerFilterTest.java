package com.intercom.meetme.controller;

import com.intercom.meetme.model.Customer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomerFilterTest {

    @Test
    public void canFilter() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(100, "X", 52.986375, -6.043701));
        customers.add(new Customer(99, "X", 52.986375, -6.043701));
        customers.add(new Customer(1, "X", 51.92893, -10.27699));
        customers.add(new Customer(2, "X", 52.986375, -6.043701));
        customers.add(new Customer(50, "X", 51.92893, -10.27699));
        customers.add(new Customer(51, "X", 52.986375, -6.043701));
        List<Customer> result = CustomerFilter.filter(customers);
        assertThat(result.size(), is(4));
        assertThat(result.get(0).getUserId(), is(2));
        assertThat(result.get(1).getUserId(), is(51));
        assertThat(result.get(2).getUserId(), is(99));
        assertThat(result.get(3).getUserId(), is(100));
    }

}