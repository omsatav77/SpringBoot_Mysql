package com.zensar.SB_by_Sharad.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.SB_by_Sharad.Entity.Product;

public interface ProductService {

	public void updateProduct( int pid,  Product p);
	public void deleteProductById( int productId);
	
	
	public Product getProductByid( int productId);
	
	public List<Product> getAllProduct();
	
	public void insertProduct( Product product,  String authorization) ;
	
	
}
