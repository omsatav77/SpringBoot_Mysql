package com.zensar.SB_by_Sharad.service;

import java.util.List;

import com.zensar.SB_by_Sharad.Entity.ProductEntity;
import com.zensar.SB_by_Sharad.dto.ProductDTO;

public interface ProductService {

	public void updateProduct(int pid, ProductEntity p);

	public void deleteProductById(int productId);

	public ProductEntity getProductByid(int productId);

	public List<ProductEntity> getAllProduct();

	public ProductDTO insertProduct(ProductDTO product, String authorization);

}
