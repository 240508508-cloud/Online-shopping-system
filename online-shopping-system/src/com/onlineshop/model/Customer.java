package com.onlineshop.model;

import com.onlineshop.enums.CustomerStatus;
import com.onlineshop.enums.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/** Customer information (similar to STUDENTS in the reference schema). */
public class Customer {
    private UUID id;
    private String customerNo;      // UK
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String email;           // UK
    private String phone;
    private String passwordHash;
    private CustomerStatus status;
    private LocalDateTime createdAt;

    public Customer() {
        this.id = UUID.randomUUID();
        this.status = CustomerStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }

    public Customer(String customerNo, String firstName, String lastName, LocalDate birthDate,
                    Gender gender, String email, String phone, String passwordHash) {
        this();
        this.customerNo = customerNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.passwordHash = passwordHash;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getCustomerNo() { return customerNo; }
    public void setCustomerNo(String customerNo) { this.customerNo = customerNo; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public CustomerStatus getStatus() { return status; }
    public void setStatus(CustomerStatus status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", customerNo='" + customerNo + "', firstName='" + firstName
                + "', lastName='" + lastName + "', birthDate=" + birthDate + ", gender=" + gender
                + ", email='" + email + "', phone='" + phone + "', status=" + status
                + ", createdAt=" + createdAt + "}";
    }
}
