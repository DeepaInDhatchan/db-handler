package com.example.laptopcustomer2tables;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LaptopController<LaptopProjection> {
	
	@Autowired
	private LaptopRepository lRepo;
	
	@Autowired
	private BrandRepository bRepo;

	@GetMapping("/laptops")
	public ResponseEntity<List<LaptopProjection>> getData (@RequestParam String brand) {
		return new ResponseEntity<List<LaptopProjection>>(lRepo.findLaptopDetailsByBrand(brand), HttpStatus.OK);
	}
}