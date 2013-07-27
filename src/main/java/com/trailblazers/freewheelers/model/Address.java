package com.trailblazers.freewheelers.model;

public class Address {
    private long address_id;
    private long account_id;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Address() {
        this.address_id = 0L;
//        this.account_id = 1L;
//        this.street1 = "";
//        this.street2 = "";
//        this.city = "";
//        this.state = "";
//        this.country = "";
//        this.zipCode = "";
    }

    public long getAddress_id() {
        return address_id;
    }

    public long getAccount_id() {
        return account_id;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Address setAddress_id(long address_id) {
        this.address_id = address_id;
        return this;
    }

    public Address setAccount_id(long account_id) {
        this.account_id = account_id;
        return this;
    }

    public Address setStreet1(String street1) {
        this.street1 = street1;
        return this;
    }

    public Address setStreet2(String street2) {
        this.street2 = street2;
        return this;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }
}
