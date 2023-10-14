package com.DDAC.SpringAngular.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; 

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "product_id", length = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "product_title", length = 50)
    private String title;
	
    @Column(name = "product_price")
    private double price;
	
    @Column(name = "product_image", length = 50)
    private String image;
	
    @Column(name = "product_status", length = 50)
    private String status;
    
    @Column(name = "product_is_best_seller")
    private boolean isBestSeller;
    
	
	 	
	public Product(Long id, String title, double price, String image, String status, boolean isBestSeller) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.image = image;
		this.status = status;
		this.isBestSeller = isBestSeller;
	}

	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}	
	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isBestSeller() {
		return isBestSeller;
	}

	public void setBestSeller(boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", image=" + image + ", status=" + status
				+ ", isBestSeller=" + isBestSeller + "]";
	}

	
	
	
}
