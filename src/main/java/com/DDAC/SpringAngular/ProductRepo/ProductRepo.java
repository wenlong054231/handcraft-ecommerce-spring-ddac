package com.DDAC.SpringAngular.ProductRepo;

import java.util.List;

import com.DDAC.SpringAngular.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long>{

	List<Product> findAll();

}	
	