package com.paypay.challenge.test.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Mutable model class defining user instances. This class definition is used in
 * testing the deep copy of objects and immutable queue demonstration.
 * 
 * @author hoang.tran
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private Date birthDate;
    private Address address;
}