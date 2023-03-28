package com.example.ecommerce.business.concretes;

import com.example.ecommerce.business.abstracts.ProductService;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Component
public class ProductManager implements ProductService {

	private final ProductRepository repository;

	private final ModelMapper modelMapper;

	@Override
	public List<Product> getAll() {

		return repository.findAll();
	}

	@Override
	public Product getById(int id) {

		return repository.findById(id).orElseThrow();
	}

	@Override
	public Product add(Product product) {

		validateProduct(product);
		return repository.save(product);
	}

	@Override
	public Product update(int id, Product product) {

		validateProduct(product);
		return repository.save(product);
	}

	@Override
	public void delete(int id) {

		repository.delete(repository.findById(id).orElseThrow());
	}

	//! Business rules

	private void validateProduct(Product product) {

		checkIfUnitPriceValid(product);
		checkIfQuantityValid(product);
		checkIfDescriptionLengthValid(product);
	}

	private void checkIfUnitPriceValid(Product product) {

		if (product.getUnitPrice() <= 0)
			throw new IllegalArgumentException("Price cannot be less than or equal to zero.");
	}

	private void checkIfQuantityValid(Product product) {

		if (product.getQuantity() < 0)
			throw new IllegalArgumentException("Quantity cannot be less than zero.");
	}

	private void checkIfDescriptionLengthValid(Product product) {

		if (product.getDescription().length() < 10 || product.getDescription().length() > 50)
			throw new IllegalArgumentException("Description length must be between 10 and 50 characters.");
	}
}
