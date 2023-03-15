package com.zensar.SB_by_Sharad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private int productId;
	private String productName;
	private int productCost;
}
