package com.zensar.SB_by_Sharad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.SB_by_Sharad.Entity.ProductEntity;
import com.zensar.SB_by_Sharad.Repo.ProductRepository;
import com.zensar.SB_by_Sharad.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@PostMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ProductDTO insertProduct(@RequestBody ProductDTO productDto,
			@RequestHeader("Authorization") String authorization) {

		ProductEntity productEntity = new ProductEntity();
//		productEntity.setProductCost(productDto.getProductCost());
//		productEntity.setProductId(productDto.getProductId());
//		productEntity.setProductName(productDto.getProductName());

		productEntity = map_Set_ProductEntity(productDto);
		productRepository.save(productEntity);
		productDto = setProductDTO(productEntity);
		return productDto;

	}

	@GetMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ProductEntity> getAllProduct() {
		return productRepository.findAll();
	}

	@GetMapping(value = "/products/{productId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ProductEntity getProductByid(@PathVariable("productId") int productId) {
		return productRepository.findById(productId).get();
	}

	@DeleteMapping("/products/{productId}")
	public void deleteProductById(@PathVariable int productId) {
		productRepository.deleteById(productId);
	}

	@PutMapping("/products/{productId}")
	public void updateProduct(@PathVariable("productId") int pid, @RequestBody ProductEntity productEntity) {
		ProductEntity p1 = productRepository.findById(pid).get();
//		p1.setProductCost(productEntity.getProductCost());
//		p1.setProductId(productEntity.getProductId());
//		p1.setProductName(productEntity.getProductName());
		ProductDTO p2 = null;
		p2 = setProductDTO(productEntity);

		productRepository.save(p1);

	}

	public ProductDTO setProductDTO(ProductEntity productEntity) {
		ProductDTO productDTO = new ProductDTO();

		productDTO.setProductCost(productEntity.getProductCost());
		productDTO.setProductId(productEntity.getProductId());
		productDTO.setProductName(productEntity.getProductName());

		return productDTO;

	}

	public ProductEntity map_Set_ProductEntity(ProductDTO productDto) {

		ProductEntity productEntity = new ProductEntity();

		productEntity.setProductCost(productDto.getProductCost());
		productEntity.setProductId(productDto.getProductId());
		productEntity.setProductName(productDto.getProductName());
		return productEntity;
	}

}
