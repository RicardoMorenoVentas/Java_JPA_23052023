package com.softtek.java_jpa_23052023.modelo;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="products")
public class Product {
    @Id
    private Short productId;

    @Nonnull
    private String productName;

    
    private Short supplierId;

    
    private Short categoryId;

    
    private String quantityPerUnit;

    
    private double unitPrice;

    
    private Short unitsInStock;

    
    private Short unitsOnOrder;

    
    private Short reorderLevel;

    
    private int discontinued;
}
