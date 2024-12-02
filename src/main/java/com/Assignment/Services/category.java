package com.Assignment.Services;

import com.Assignment.Entites.categories;

import java.util.List;

public interface category {

    //Get all the categories
    List<categories> getAllCategory(Integer pageNumber,Integer pageSize);

    //Create Categories
    categories createCategory(categories categories);

    //Get categories by id
    categories getCategoryById(long id);

    //Update Category by id
    categories updateCategoryById(categories categories,long id);

    //Delete categories by id
    String deleteCategory(long id);







}
