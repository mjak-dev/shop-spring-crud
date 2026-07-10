package org.example.session6practice.data.repositories;

import org.example.session6practice.data.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
//    @Query(value = "delete from Orders.products products where products.id=:productId")
//    void deleteProductById(long productId);

//    @Query(value = "delete from Orders.products products where products.id=:id and products.productName=:productName and products.price=:price and products.productDescription=:productDescription ")
//    void deleteProduct(long id,String productName, long price,String productDescription);
}
