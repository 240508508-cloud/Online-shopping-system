package com.onlineshop.model;

import com.onlineshop.enums.AddressType;

import java.util.UUID;

/** Shipping / billing address. FK -> customers. */
public class Address {
    private UUID id;
    private Customer customer;      // FK -> customers
    private AddressType type;
    private String title;           // e.g. "Home", "Office"
    private String addressLine;
    private String city;
    private String district;
    private String postalCode;
    private String country;
    private boolean isDefault;

    public Address() {
        this.id = UUID.randomUUID();
    }

    public Address(Customer customer, AddressType type, String title, String addressLine,
                   String city, String district, String postalCode, String country) {
        this();
        this.customer = customer;
        this.type = type;
        this.title = title;
        this.addressLine = addressLine;
        this.city = city;
        this.district = district;
        this.postalCode = postalCode;
        this.country = country;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public AddressType getType() { return type; }
    public void setType(AddressType type) { this.type = type; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAddressLine() { return addressLine; }
    public void setAddressLine(String addressLine) { this.addressLine = addressLine; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public boolean isDefault() { return isDefault; }
    public void setDefault(boolean aDefault) { isDefault = aDefault; }

    @Override
    public String toString() {
        return "Address{id=" + id + ", customerId=" + (customer != null ? customer.getId() : null)
                + ", type=" + type + ", title='" + title + "', addressLine='" + addressLine
                + "', district='" + district + "', city='" + city + "', postalCode='" + postalCode
                + "', country='" + country + "', isDefault=" + isDefault + "}";
    }
}
