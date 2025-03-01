package com.snsc.springproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "address_tbl")
public class Address {
	@Id
	@GeneratedValue
	private int id;
	private String country;
	private String city;
	private String state;
	private String zipcode;

}
