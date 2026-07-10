package org.example.session6practice.data.services;

import org.example.session6practice.data.entities.Product;
import org.example.session6practice.data.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addOrUpdate(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public void deleteByName(String productName){
        productRepository.deleteByProductName(productName);
    }

    public List<Product> findAll(int perPage,int pageNo) {
        return productRepository.findAll(PageRequest.of(pageNo,perPage)).stream().toList();
    }

    public List<Product> search(String searchParam,int perPage,int pageNo) {
        return productRepository.searchProductByProductDescriptionEqualsIgnoreCaseOrProductNameEqualsIgnoreCase(searchParam,PageRequest.of(pageNo,perPage)).stream().toList();
    }

}
