package com.trailblazers.freewheelers.model;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/26/13
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Address {
    private final String street1;
    private final String street2;
    private final String city;
    private final String state;
    private final String country;
    private final String zipCode;

    public Address(String street1, String street2, String city, String state, String country, String zipCode) {
        //To change body of created methods use File | Settings | File Templates.
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
}
