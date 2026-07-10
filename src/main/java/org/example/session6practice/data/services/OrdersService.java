package org.example.session6practice.data.services;

import org.example.session6practice.data.entities.Orders;
import org.example.session6practice.data.entities.Product;
import org.example.session6practice.data.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public void addOrUpdate(Orders orders) {
        ordersRepository.save(orders);
    }

    public void deleteOneOrder(Product product) {
        ordersRepository.delete(new Orders(product));
    }

    public void deleteOrderById(long id) {
        ordersRepository.deleteById(id);
    }

    public List<Orders> findAll(int perPage,int pageNo) {
        return ordersRepository.findAll(PageRequest.of(pageNo,perPage)).stream().toList();
    }

    public List<Orders> findAllById(List<Long> id) {
        return ordersRepository.findAllById(id);
    }
}
