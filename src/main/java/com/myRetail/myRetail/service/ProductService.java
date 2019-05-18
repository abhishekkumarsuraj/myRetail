package com.myRetail.myRetail.service;

import com.myRetail.myRetail.model.Product;
import com.myRetail.myRetail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

   public long idCounter = 15117729;

    @Autowired
    private ProductRepository  productRepository;

    @Override
    public Iterable<Product> getAllProduct()
    {
        Iterable<Product> allProducts = productRepository.findAll();
        return allProducts;
    }

    @Override
    public Optional<Product> getProductByID(long id)
    {
        return productRepository.findById(id);
    }

    @Override
    public Product addProduct(Product newProd) {

        System.out.println("At addProduct() in Service"+newProd);
        if(newProd.getId() == 0)
        {
           newProd.setId(idCounter);
            idCounter++;
            return productRepository.save(newProd);
        }
        else
        {
            return productRepository.save(newProd);
        }
    }


}
