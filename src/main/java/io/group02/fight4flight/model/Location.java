package io.group02.fight4flight.model;

public class Location {

    private String Country;
    private String City;
    private String Street;
    private String PostalCode;

    public Location(String Country, String City, String Street, String PostalCode) {
        // USE THIS CONSTUCTOR FOR ADDRESSES
        this.Country = Country;
        this.City = City;
        this.Street = Street;
        this.PostalCode = PostalCode;
    }

    public Location() {
    } // Default Constructor

    public Location(String Country, String City, String CountryCode) {
        // USE THIS CONSTRUCTOR FOR AIRPORTS
        this.Country = Country;
        this.City = City;
        this.PostalCode = CountryCode;
        this.Street = "Airport";

    }
    // Getters

    public String getCountry() {
        return this.Country;
    }

    public String getCity() {
        return this.City;
    }

    public String getStreet() {
        return this.Street;
    }

    public String getPostalCode() {
        return this.PostalCode;
    }

    //Setters
    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

}