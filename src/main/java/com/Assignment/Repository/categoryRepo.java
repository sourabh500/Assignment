package com.Assignment.Repository;


import com.Assignment.Entites.categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepo extends JpaRepository<categories,Long> {
}
