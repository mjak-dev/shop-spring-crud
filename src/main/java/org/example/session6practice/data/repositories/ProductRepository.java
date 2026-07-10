package org.example.session6practice.data.repositories;

import org.example.session6practice.data.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Long> {

    void deleteByProductName(String productName);

    @Query(value = "select Product from Product where productName like '%:searchValue%' or productDescription like '%:searchValue%'")
    Page<Product> searchProductByProductDescriptionEqualsIgnoreCaseOrProductNameEqualsIgnoreCase(String searchValue, Pageable pageable);

}