package com.satya.mvc.entity;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Data
@AllArgsConstructor

@NoArgsConstructor
@Entity
@Table(name="product")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String Name;
	private String Brand;
	private String Madein;
	private double Price;
	private int Quantity;
	private double DiscountRate;
	private double DiscountPrice;
	private double TaxPrice;
	private double OfferPrice;
	private double finalPrice;
	private double stockValue;	
}
