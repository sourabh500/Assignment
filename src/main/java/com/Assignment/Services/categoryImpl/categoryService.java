package com.Assignment.Services.categoryImpl;

import com.Assignment.Entites.categories;
import com.Assignment.Entites.products;
import com.Assignment.Repository.categoryRepo;
import com.Assignment.Repository.productRepo;
import com.Assignment.Services.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class categoryService implements category {


    @Autowired
    categoryRepo categoryRepo;

    @Autowired
    productRepo productRepo;


    @Override
    public List<categories> getAllCategory(Integer pageNumber, Integer pageSize) {
        //pagination
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<categories> page= categoryRepo.findAll(pageable);
        List<categories>  allCategories= page.getContent();
        return allCategories;
    }

    @Override
    public categories createCategory(categories categories) {
        categories.setName(categories.getName());

        // Create a list of products (you need to fetch or create them based on the input)
        List<products> productsList = new ArrayList<>();

        // Assuming the products are passed along with the category in the request
        for (products products:categories.getProduct())
        {
            products.setCategories(categories);  // Associate the category with the product
            productsList.add(products);
        }

        // Set the list of products in the category
        categories.setProduct(productsList);

        return categoryRepo.save(categories);
    }

    @Override
    public categories getCategoryById(long id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public categories updateCategoryById(categories categories, long id) {

        // Fetch the existing category from the database
      categories categories1=  categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        // Update the category's name
        categories1.setName(categories.getName());
        // Update the associated products (if any)
        // Assuming you're passing a list of products to update the category's products
        List<products> updatedProductsList = categories.getProduct(); // Assuming the products are passed

        // Update each product's category reference
        for (products products:updatedProductsList)
        {
            products.setCategories(categories1);   // Set the correct category for each product
        }

        // Save the updated products back to the database

        productRepo.saveAll(updatedProductsList);  //Save the products after updating

        // Save the updated category
       return categoryRepo.save(categories1);  // Save and return the updated category

    }

    @Override
    public String deleteCategory(long id) {
        categoryRepo.deleteById(id);
        return "Category has been successfully deleted";
    }
}
