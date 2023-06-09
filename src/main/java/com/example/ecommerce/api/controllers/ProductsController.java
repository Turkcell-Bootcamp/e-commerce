package com.example.ecommerce.api.controllers;

import com.example.ecommerce.business.abstracts.ProductService;
import com.example.ecommerce.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {

	private final ProductService productService;

	@GetMapping
	public List<Product> getAll() {

		return productService.getAll();
	}

	@GetMapping("/{id}")
	public Product getById(@PathVariable int id) {

		return productService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product add(@RequestBody Product product) {

		return productService.add(product);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product update(@PathVariable int id, @RequestBody Product product) {

		return productService.update(id, product);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {

		productService.delete(id);
	}
}
