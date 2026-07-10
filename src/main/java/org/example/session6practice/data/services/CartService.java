package org.example.session6practice.data.services;

import org.example.session6practice.data.entities.Cart;
import org.example.session6practice.data.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.List;

@Component
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void addOrUpdate(Cart cart) {
        cartRepository.save(cart);
    }

    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

    public void deleteById(long id) {
        cartRepository.deleteById(id);
    }

    public List<Cart> findAll(int perPage,int pageNo) {
        return cartRepository.findAll(PageRequest.of(pageNo,perPage)).stream().toList();
    }

    public Cart findById(long id) {
        return cartRepository.findById(id).get();
    }

}
