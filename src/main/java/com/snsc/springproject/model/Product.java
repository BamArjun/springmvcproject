package com.snsc.springproject.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="product_tbl")
public class Product {
	@Id
	@GeneratedValue
private int id;
private String title;
private double price;
@Column(columnDefinition ="longtext")
private String  description;
private String category;
private String  image;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="rating_id")
private Rating rating;

}
