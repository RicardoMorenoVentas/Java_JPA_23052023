package com.softtek.java_jpa_23052023.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
public class AverageSupplierDTO {
    private Short supplierId;
    private double average;
}
