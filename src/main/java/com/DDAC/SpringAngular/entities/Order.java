package com.DDAC.SpringAngular.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "placed_date")
    private Date placedDate;

    @Column(name = "completed_date")
    private Date completedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_id")
    private Long customerId;
    
    @Column(name = "item_id")
    private Long itemId;

	
	
	public Order(Long id, BigDecimal totalPrice, Date placedDate, Date completedDate, String status,
			String customerName, Long customerId, Long itemId) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.placedDate = placedDate;
		this.completedDate = completedDate;
		this.status = status;
		this.customerName = customerName;
		this.customerId = customerId;
		this.itemId = itemId;
	}


	public Order() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getPlacedDate() {
		return placedDate;
	}

	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	

	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", totalPrice=" + totalPrice + ", placedDate=" + placedDate + ", completedDate="
				+ completedDate + ", status=" + status + ", customerName=" + customerName + ", customerId=" + customerId
				+ ", itemId=" + itemId + "]";
	}
	

    
}
