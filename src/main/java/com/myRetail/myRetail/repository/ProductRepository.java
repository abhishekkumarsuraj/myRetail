package com.myRetail.myRetail.repository;

import com.myRetail.myRetail.model.CurrentPrice;
import com.myRetail.myRetail.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Arrays;
import java.util.List;

public interface ProductRepository  extends CrudRepository<Product,Long>{

}
