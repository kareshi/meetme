package com.intercom.meetme.model;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class LineReaderTest {

    @Test
    public void canBuild() {
        InputStream is = CustomersFactory.class.getClassLoader().getResourceAsStream("customers.txt");
        List<String> result = LineReader.build(is);

        Assert.assertThat(result.size(), Is.is(2));
        Assert.assertThat(result.get(0), Is.is("{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}"));
        Assert.assertThat(result.get(1), Is.is("{\"latitude\": \"51.92893\", \"user_id\": 1, \"name\": \"Alice Cahill\", \"longitude\": \"-10.27699\"}"));

    }


}