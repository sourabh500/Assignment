package com.Assignment.Controller;

import com.Assignment.Entites.categories;
import com.Assignment.Entites.products;
import com.Assignment.Services.productImpl.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class product {

    @Autowired
    productService productService;

    //Getting all the products
    @GetMapping
    public ResponseEntity<List<products>> getAllProducts(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "5",required = false)Integer pageSize)
    {
        List<products> products = productService.getAllProducts(pageNumber,pageSize);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //Getting products by id
    @GetMapping("/{id}")
    public ResponseEntity<products> getProductById(@PathVariable long id)
    {
        products products=productService.getProductById(id);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    //Creating product
    @PostMapping
    public ResponseEntity<products> createProduct(@RequestBody products products)
    {
      products products1=  productService.createProduct(products);
        return new ResponseEntity<>(products1,HttpStatus.CREATED);
    }

    //Updating product by id
    @PutMapping("/{id}")
    public ResponseEntity<products> updateProductById(@RequestBody products products, @PathVariable long id)
    {
       products products1= productService.updateProductById(products,id);
        return new ResponseEntity<>(products1,HttpStatus.OK);
    }

    //Deleting product bt id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable long id)
    {

        String product= productService.deleteProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);

    }
}
