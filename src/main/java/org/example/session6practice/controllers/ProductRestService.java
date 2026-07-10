package org.example.session6practice.controllers;

import org.example.session6practice.Finals;
import org.example.session6practice.data.entities.Product;
import org.example.session6practice.data.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Product")
public class ProductRestService {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_PLAIN_VALUE)
    @GetMapping("/json")
    public Map<String,String> addOrUpdate(@RequestBody Product product) {
        productService.addOrUpdate(product);

        Map<String,String> map = new HashMap<>();
        map.put("response","Product added successfully done");
        return map;
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/json")
    public Map deleteById(long id) {
        productService.deleteById(id);

        Map<String,String> map = new HashMap<>();
        map.put("response","Product has been deleted successfully done");
        return map;
    }

    @RequestMapping(value = "deleteByName",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/json")
    public Map<String, String> deleteByName(String name) {
        productService.deleteByName(name);

        Map<String,String> map = new HashMap<>();
        map.put("response","Product has been deleted successfully done");
        return map;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAll(int pageNo) {
        return productService.findAll(Finals.PER_PAGE_PAGINATION,pageNo);
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public List<Product> search(String searchParam,int perPage,int pageNo) {
        return productService.search(searchParam,perPage,pageNo);
    }


}