package com.softtek.java_jpa_23052023.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Short productId;
    private String productName;
    private Short supplierId;
    private Short categoryId;
    private double unitPrice;
    private int discontinued;
}
