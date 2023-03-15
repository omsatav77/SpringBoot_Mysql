package com.zensar.SB_by_Sharad.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.SB_by_Sharad.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
