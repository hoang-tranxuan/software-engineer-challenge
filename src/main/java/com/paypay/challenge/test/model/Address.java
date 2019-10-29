package com.paypay.challenge.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Mutable model class defining user address information. This class is used in
 * testing the deep copy of objects and immutable queue demonstration.
 * 
 * @author hoang.tran
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private String country;
    private String city;
    private int zipCode;
}