package com.zensar.SB_by_Sharad.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

	@Id
	@Column(name="id")
	private int productId;

	@Column(name="product_name")
	private String productName;
	@Column(name="cost")
	private int productCost;




}
