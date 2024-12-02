package com.Assignment.Repository;

import com.Assignment.Entites.products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepo extends JpaRepository<products,Long> {
}
