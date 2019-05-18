package com.myRetail.myRetail.controller;

import com.myRetail.myRetail.model.Product;
import com.myRetail.myRetail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api" )
public class ApiController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> getProducts()
    {
        Iterable<Product> products = productService.getAllProduct();
        return products;
    }

    @GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Product> getProduct(@PathVariable Long id) {

        Optional<Product> product = productService.getProductByID(id);
        return product;
    }

    @PostMapping(path = "/addProduct",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody Product product)
    {

        System.out.println("At addProduct()"+product);

        if(product!=null)
        {
            Product reply = productService.addProduct(product);
            if(reply !=null)  return new ResponseEntity(reply,HttpStatus.CREATED);
            else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
        else if(product.getName()==null)
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        else
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
