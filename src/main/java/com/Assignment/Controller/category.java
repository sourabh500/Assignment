package com.Assignment.Controller;

import com.Assignment.Entites.categories;
import com.Assignment.Services.categoryImpl.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class category {

    @Autowired
    categoryService categoryService;

    //Getting all the categories
    @GetMapping
    public ResponseEntity<List<categories>> getAllCategories(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "5",required = false)Integer pageSize)
    {
      List<categories> categories= categoryService.getAllCategory(pageNumber,pageSize);
      return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //Getting category by id
    @GetMapping("/{id}")
    public ResponseEntity<categories> getCategoryById(@PathVariable long id)
    {
       categories categories= categoryService.getCategoryById(id);
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    //Creating category
    @PostMapping
    public ResponseEntity<categories> createCategory(@RequestBody categories categories)
    {
        categories categories1=categoryService.createCategory(categories);
        return new ResponseEntity<>(categories1,HttpStatus.CREATED);
    }

    //Updating categories by id
    @PutMapping("/{id}")
    public ResponseEntity<categories> updateCategoryById(@RequestBody categories categories,@PathVariable long id)
    {
        categories categories1= categoryService.updateCategoryById(categories,id);
        return new ResponseEntity<>(categories1,HttpStatus.OK);
    }

    //Deleting category by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable long id)
    {

        String category=  categoryService.deleteCategory(id);
        return new ResponseEntity<>(category,HttpStatus.OK);

    }


}
