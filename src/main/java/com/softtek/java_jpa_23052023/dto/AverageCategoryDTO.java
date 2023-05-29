package com.softtek.java_jpa_23052023.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AverageCategoryDTO {
    private Short categoryID;
    private double average;
}
