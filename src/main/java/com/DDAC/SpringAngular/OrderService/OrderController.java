package com.DDAC.SpringAngular.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DDAC.SpringAngular.Service.OrderService;
import com.DDAC.SpringAngular.entities.Order;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
	
    @CrossOrigin 
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
       
    	System.out.println("Order: " + order);
        Order createdOrder = orderService.saveOrder(order);
        
        System.out.println("Created Order: " + createdOrder);
        return ResponseEntity.ok(createdOrder);
    }
    
    @CrossOrigin
    @PostMapping("/refund/{orderId}")
    public ResponseEntity<String> refundOrder(@PathVariable Long orderId) {
        try {
            Order refundedOrder = orderService.refundOrder(orderId);
            return ResponseEntity.ok("Order with ID " + refundedOrder.getId() + " has been refunded.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process refund");
        }
    }
    
    @CrossOrigin
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        try {
            Order order = orderService.getOrderById(orderId);
            if (order != null) {
                return ResponseEntity.ok(order);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    
    @CrossOrigin
    @PostMapping("/cancel/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        try {
            orderService.cancelOrder(orderId);
            return ResponseEntity.ok("Order with ID " + orderId + " has been cancelled.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete order");
        }
    }
}