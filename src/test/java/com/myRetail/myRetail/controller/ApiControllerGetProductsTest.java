package com.myRetail.myRetail.controller;

import com.myRetail.myRetail.model.CurrentPrice;
import com.myRetail.myRetail.model.Product;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.myRetail.myRetail.repository.ProductRepository;
import com.myRetail.myRetail.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class ApiControllerGetProductsTest {

    @Mock
    private ProductRepository productRepository ;

    @InjectMocks
    private ProductService productService;


    @Test
    public void getProducts() throws Exception
    {
        int temp =0 ;
        List<Product> toDoList = new ArrayList<Product>();
        toDoList.add(new Product(15117756,"The Big Lebowski (Blu-ray) (Widescreen) ",new CurrentPrice(15.05,"USD")));
        toDoList.add(new Product(15117757,"Todo Sample 2",new CurrentPrice(15.05,"USD")));
        toDoList.add(new Product(15117758,"Todo Sample 3",new CurrentPrice(15.05,"USD")));
        toDoList.add(new Product(15117759,"Todo Sample 3",new CurrentPrice(15.05,"USD")));
        toDoList.add(new Product(15117760,"Todo Sample 3",new CurrentPrice(15.05,"USD")));
        toDoList.add(new Product(15117761,"Todo Sample 3",new CurrentPrice(15.05,"USD")));
        toDoList.add(new Product(15117762,"Todo Sample 3",new CurrentPrice(15.05,"USD")));
        toDoList.add(new Product(15117763,"Todo Sample 3",new CurrentPrice(15.05,"USD")));
        toDoList.add(new Product(15117764,"Todo Sample 3",new CurrentPrice(15.05,"USD")));
        toDoList.add(new Product(15117765,"Todo Sample 3",new CurrentPrice(15.05,"USD")));
        toDoList.add(new Product(15117766,"Todo Sample 3",new CurrentPrice(15.05,"USD")));
        toDoList.add(new Product(15117767,"Todo Sample 3",new CurrentPrice(15.05,"USD")));

        when(productRepository.findAll()).thenReturn(toDoList);

        Iterable<Product> result = (Iterable<Product>) productService.getAllProduct();
        Iterator<Product> itr = result.iterator();
        while (itr.hasNext())
        {
            temp = (int) (itr.next()).getId();
            System.out.println(temp);

            if(temp == 15117757)
            {
               break;
            }
        }

        assertEquals(15117757, temp);
    }
}
