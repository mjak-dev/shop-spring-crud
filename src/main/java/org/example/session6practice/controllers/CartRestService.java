package org.example.session6practice.controllers;

import org.example.session6practice.Finals;
import org.example.session6practice.data.entities.Cart;
import org.example.session6practice.data.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartRestService {

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.POST)
    @GetMapping("/json")
    public Map<String,String> addOrUpdate(Cart cart) {
        cartService.addOrUpdate(cart);

        Map<String,String> map = new HashMap<>();
        map.put("response","Cart added successfully");
        return map;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @GetMapping("/json")
    public Map<String,String> delete(Cart cart) {
        cartService.deleteCart(cart);

        Map<String,String> map = new HashMap<>();
        map.put("response","Cart deleted successfully");
        return map;
    }

    @RequestMapping(value = "deleteById",method = RequestMethod.DELETE)
    @GetMapping
    public Map<String,String> deleteById(long id){
        cartService.deleteById(id);

        Map<String,String> map = new HashMap<>();
        map.put("response","Cart deleted successfully");
        return map;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Cart> getCarts(int pageNo) {
        return cartService.findAll(Finals.PER_PAGE_PAGINATION,pageNo);
    }

    @RequestMapping(value = "GetCartById",method = RequestMethod.GET)
    public Cart getCartById(long id) {
        return cartService.findById(id);
    }



}
