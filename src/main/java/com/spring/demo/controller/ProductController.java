package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.entity.Product;
import com.spring.demo.repository.ProductRepo;

@RestController
public class ProductController {
	@Autowired
	ProductRepo prdRepo;

	// saving data
	@PostMapping("/product")
	public Product saveData(@RequestBody Product prd) {
		prdRepo.save(prd);
		return prd;
	}

	// get All Data
	@GetMapping("/product")
	public List<Product> getAllRecord() {
		List<Product> prd = prdRepo.findAll();
		if (!prd.isEmpty()) {
			return prd;
		} else {
			return null;
		}
	}

	// get only one data
	@GetMapping("/product/{id}")
	public Product getAnData(@PathVariable int id) {
		Optional<Product> product = prdRepo.findById(id);
		if (product.isPresent()) {
			return product.get();
		} else {
			return null;
		}

	}

	// Update Data
	@PutMapping("product")
	String updateProduct(@RequestBody Product prd) {

		Product sv = prdRepo.save(prd);
		return "Data Updated";
	}
	
//	//One data Update
//	@PatchMapping("product/{id}")
//	String oneUpdate(@PathVariable int id) {
//		sv=prdRepo.save()
//		return null;
//	}
	
	//Delete Data
	@DeleteMapping("/product/{id}")
	String removeData(@PathVariable int id){
		Optional<Product> data = prdRepo.findById(id);
		if(!data.isPresent()) {
			return "There's No data to remove from data base";
		}
		else {
			Product d = data.get();
			prdRepo.delete(d);
			return "Data has been deleted";
		}
	}
}
