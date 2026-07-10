package org.example.session6practice.data.repositories;

import org.example.session6practice.data.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart,Long> {
//    @Query(value = "insert ")
}
