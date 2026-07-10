package org.example.session6practice.controllers;

import org.example.session6practice.Finals;
import org.example.session6practice.data.entities.Orders;
import org.example.session6practice.data.entities.Product;
import org.example.session6practice.data.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Orders")
public class OrdersRestService {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(method = RequestMethod.POST)
    @GetMapping("/json")
    public Map<String,String> addOrUpdate(Orders orders) {
        ordersService.addOrUpdate(orders);

        Map<String,String> map = new HashMap<>();
        map.put("response","Orders added successfully");
        return map;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @GetMapping("/json")
    public Map<String,String> deleteById(long id) {
        ordersService.deleteOrderById(id);

        Map<String,String> map = new HashMap<>();
        map.put("response","Orders deleted successfully");
        return map;
    }

    @RequestMapping(value = "DeleteProduct",method = RequestMethod.DELETE)
    @GetMapping("/json")
    public Map<String,String> deleteProduct(Product product) {
        ordersService.deleteOneOrder(product);

        Map<String,String> map = new HashMap<>();
        map.put("response","Product deleted from Orders successfully");
        return map;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Orders> getAllOrders(int pageNo) {
        return ordersService.findAll(Finals.PER_PAGE_PAGINATION,pageNo);
    }

    @RequestMapping(value = "/ordersById",method = RequestMethod.GET)
    public List<Orders> getOrdersById(List<Long> id) {
        return ordersService.findAllById(id);
    }

}
