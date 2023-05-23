package com.softtek.java_jpa_23052023.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.annotation.Nonnull;
import lombok.Data;

@Entity
@Data
@Table(name="customers")
public class Customer {
    @Id
    private String customerId;
    @Nonnull
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;


}
