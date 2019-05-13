package edu.uark.commands.products;

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.api.Product;
import edu.uark.models.entities.ProductEntity;
import edu.uark.models.repositories.ProductRepository;
import edu.uark.models.repositories.interfaces.ProductRepositoryInterface;

public class ProductQuery implements ResultCommandInterface<Product> {
	@Override
	public Product execute() {
		ProductEntity productEntity = this.productRepository.get(this.productId);
		if (productEntity != null) {
			return new Product(productEntity);
		} else {
			throw new NotFoundException("Product");
		}
	}

	//Properties
	private UUID productId;
	public UUID getProductId() {
		return this.productId;
	}
	public ProductQuery setProductId(UUID productId) {
		this.productId = productId;
		return this;
	}
	
	private ProductRepositoryInterface productRepository;
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public ProductQuery setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
	
	public ProductQuery() {
		this.productRepository = new ProductRepository();
	}
}
