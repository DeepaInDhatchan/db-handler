package com.example.laptopcustomer2tables;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.context.request.WebRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_laptops")
@Getter
@Setter
@NoArgsConstructor
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	private BigDecimal price;

	public Laptop(Long id, String name, Brand brand, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public Laptop(String name, Brand brand, BigDecimal price) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public Laptop(String name, Brand brand) {
		super();
		this.name = name;
		this.brand = brand;
	}
	
	
	
}