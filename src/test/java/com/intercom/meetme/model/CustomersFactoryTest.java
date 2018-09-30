package com.intercom.meetme.model;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.intercom.meetme.model.CustomersFactory.buildCustomer;
import static com.intercom.meetme.model.CustomersFactory.buildCustomers;

public class CustomersFactoryTest {

    @Test
    public void canBuildCustomers() {
        List<String> jsons = new ArrayList<>();
        jsons.add("{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}");
        jsons.add("{\"latitude\": \"51.92893\", \"user_id\": 1, \"name\": \"Alice Cahill\", \"longitude\": \"-10.27699\"}");
        List<Customer> customers = buildCustomers(jsons);
        Assert.assertThat(customers.size(), Is.is(2));
        Assert.assertThat(customers.get(0).getLatitude(), Is.is(52.986375));
        Assert.assertThat(customers.get(0).getUserId(), Is.is(12));
        Assert.assertThat(customers.get(0).getName(), Is.is("Christina McArdle"));
        Assert.assertThat(customers.get(0).getLongitude(), Is.is(-6.043701));
        Assert.assertThat(customers.get(1).getLatitude(), Is.is(51.92893));
        Assert.assertThat(customers.get(1).getUserId(), Is.is(1));
        Assert.assertThat(customers.get(1).getName(), Is.is("Alice Cahill"));
        Assert.assertThat(customers.get(1).getLongitude(), Is.is(-10.27699));
    }
    @Test
    public void canBuildCustomer() {
        String json = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}";
        Customer customer = buildCustomer(json);
        Assert.assertThat(customer.getLatitude(), Is.is(52.986375));
        Assert.assertThat(customer.getUserId(), Is.is(12));
        Assert.assertThat(customer.getName(), Is.is("Christina McArdle"));
        Assert.assertThat(customer.getLongitude(), Is.is(-6.043701));

    }

}