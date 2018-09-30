package com.intercom.meetme.controller;

import org.junit.Test;

import static com.intercom.meetme.controller.DistanceCalculator.OFFICE_LATITUDE;
import static com.intercom.meetme.controller.DistanceCalculator.OFFICE_LONGITUDE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DistanceCalculatorTest {

    @Test
    public void canConvertRadiusToDegree() {
        assertThat(DistanceCalculator.rad2deg(0), is(0.0));
        assertThat(DistanceCalculator.rad2deg(Math.PI / 2), is(90.0));
        assertThat(DistanceCalculator.rad2deg(Math.PI), is(180.0));
        assertThat(DistanceCalculator.rad2deg(3 * Math.PI / 2), is(270.0));
    }

    @Test
    public void canConvertDegreeToRadius() {
        assertThat(DistanceCalculator.deg2rad(0.0), is(0.0));
        assertThat(DistanceCalculator.deg2rad(90.0), is(Math.PI / 2));
        assertThat(DistanceCalculator.deg2rad(180.0), is(Math.PI));
        assertThat(DistanceCalculator.deg2rad(270.0), is(3 * Math.PI / 2));
    }

    @Test
    public void canCalculateDistanceToDublinOffice() {
        double distance1 = DistanceCalculator.distance(52.986375, -6.043701, OFFICE_LATITUDE, OFFICE_LONGITUDE, "K");
        assertThat(((double)Math.round(distance1*100))/100, is(41.77 )); //expected value from https://www.geodatasource.com/distance-calculator
        double distance2 = DistanceCalculator.distance(51.92893, -10.27699, OFFICE_LATITUDE, OFFICE_LONGITUDE, "K");
        assertThat(((double)Math.round(distance2*100))/100, is(313.24)); //expected value from https://www.geodatasource.com/distance-calculator
    }


}