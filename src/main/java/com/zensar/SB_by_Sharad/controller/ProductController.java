package com.zensar.SB_by_Sharad.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.SB_by_Sharad.Entity.Product;

@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE })
public class ProductController {

	List<Product> products = new ArrayList<>();

	public ProductController() {
//		products.add(new Product(2,"as",34));
//		products.add(new Product(3,"aas",344));
	}

	@GetMapping("/he")
	public String he() {
		return "<h2>hello</h2>";
	}

	@PostMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public void insertProduct(@RequestBody Product product, @RequestHeader("Authorization") String authorization) {

//		if(authorization.equals("os123"))
		products.add(product);

	}

	@GetMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Product> getAllProduct() {
		return products;
	}

	@GetMapping(value = "/products/{productId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Product getProductByid(@PathVariable("productId") int productId) {
		for (Product product : products) {
			if (product.getProductId() == productId)
				return product;
		}
		return null;
	}

	@DeleteMapping("/products/{productId}")
	public boolean deleteProductById(@PathVariable int productId) {
		Product product = getProductByid(productId);

		return products.remove(product);
	}

}
