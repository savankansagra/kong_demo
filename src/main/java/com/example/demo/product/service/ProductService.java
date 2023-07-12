package com.example.demo.product.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {

        return productRepository.findById(id);

    }

    public void deleteProduct(Long id) {

        if(!productRepository.existsById(id)) {
            throw new ObjectNotFoundException(id, null);
        }
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product product) {

        if(!productRepository.existsById(id)) {
            throw new ObjectNotFoundException(id, null);
        }
        product.setId(id);
        return productRepository.save(product);
    }
}
