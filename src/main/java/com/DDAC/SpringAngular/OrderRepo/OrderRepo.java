package com.DDAC.SpringAngular.OrderRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DDAC.SpringAngular.entities.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{
	
	@Override
    Order save(Order order);
}
