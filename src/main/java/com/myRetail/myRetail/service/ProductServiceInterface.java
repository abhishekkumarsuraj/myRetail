package com.myRetail.myRetail.service;

import com.myRetail.myRetail.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {

    public Iterable<Product> getAllProduct();

    public Optional<Product> getProductByID(long id);

    public Product addProduct(Product newProd);

}
