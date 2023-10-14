package com.DDAC.SpringAngular.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DDAC.SpringAngular.entities.Order;

import com.DDAC.SpringAngular.OrderRepo.OrderRepo;

@Service
public class OrderService {
	
    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

	public Order saveOrder(Order order) {
		 return orderRepo.save(order); 
	}

	public Order refundOrder(Long orderId) {
		Order order = orderRepo.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus("Refunded"); // Update the status to "Refunded"
            return orderRepo.save(order); // Save the updated order
        }
        return null;
	}

	public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId).orElse(null); // Retrieve order by ID from the database
    }
	
	public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
	
	public Order cancelOrder(Long orderId) {
		Order order = orderRepo.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus("Cancelled"); // Update the status to "Refunded"
            return orderRepo.save(order); // Save the updated order
        }
        return null;
    }
    
}
