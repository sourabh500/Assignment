package com.Assignment.Services.productImpl;

import com.Assignment.Entites.products;
import com.Assignment.Repository.productRepo;
import com.Assignment.Services.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService implements product {

    @Autowired
    productRepo productRepo;

    @Override
    public List<products> getAllProducts(Integer pageNumber, Integer pageSize) {

        //Pagination
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<products> page=productRepo.findAll(pageable);
        return page.getContent();
    }

    @Override
    public products getProductById(long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public products createProduct(products product) {
        return productRepo.save(product);
    }

    @Override
    public products updateProductById(products product, long id) {

       products products1= productRepo.findById(id).get();
       products1.setName(product.getName());
       products1.setDescription(product.getDescription());
       products1.setInStock(product.isInStock());
       products1.setCategories(product.getCategories());
       return productRepo.save(products1);

    }

    @Override
    public String deleteProductById(long id) {
        productRepo.deleteById(id);
        return "Product has been successfully deleted";
    }
}
