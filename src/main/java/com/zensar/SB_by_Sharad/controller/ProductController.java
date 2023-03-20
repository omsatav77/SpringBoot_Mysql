package com.zensar.SB_by_Sharad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.SB_by_Sharad.Entity.ProductEntity;
import com.zensar.SB_by_Sharad.dto.ProductDTO;
import com.zensar.SB_by_Sharad.service.ProductServiceImpl;

@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE })
public class ProductController {

	@Autowired
	ProductServiceImpl productServiceImpl;

	@GetMapping("/he")
	public String he() {
		return "<h2>hello</h2>";
	}

	@PostMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProductEntity> insertProduct(@RequestBody ProductDTO productDto,
			@RequestHeader("Authorization") String authorization) {
		productServiceImpl.insertProduct(productDto, authorization);
		return new ResponseEntity<ProductEntity>(productServiceImpl.insertProduct(productDto, authorization),
				HttpStatus.CREATED);

	}

	@GetMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ProductEntity>> getAllProduct() {
		 productServiceImpl.getAllProduct();
		 return new ResponseEntity<List<ProductEntity>>(productServiceImpl.getAllProduct(), HttpStatus.FOUND);
	}

	@GetMapping(value = "/products/{productId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProductEntity> getProductByid(@PathVariable("productId") int productId) {
		productServiceImpl.getProductByid(productId);
		return new ResponseEntity<ProductEntity>(productServiceImpl.getProductByid(productId), HttpStatus.FOUND);
	}

	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable int productId) {
		productServiceImpl.deleteProductById(productId);
		return new ResponseEntity<String>("product deleted", HttpStatus.OK);
	}

	@PutMapping("/products/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable("productId") int pid, @RequestBody ProductEntity p) {
		productServiceImpl.updateProduct(pid, p);
		return new ResponseEntity<String>("product updated", HttpStatus.OK);
	}

}
