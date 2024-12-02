package com.Assignment.Services;

import com.Assignment.Entites.products;

import java.util.List;

public interface product {


    //Get all the products
    List<products> getAllProducts(Integer pageNumber,Integer pageSize);

    //Get product by id
    products getProductById(long id);

    //Create Product
    products createProduct(products product);

    //Update product by id
    products updateProductById(products product,long id);

    //Delete product
    String deleteProductById(long id);








}
