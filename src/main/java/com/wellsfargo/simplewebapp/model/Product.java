package com.wellsfargo.simplewebapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
private Integer productId;
private String productName;
private float price;
}
