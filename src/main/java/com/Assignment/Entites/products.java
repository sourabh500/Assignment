package com.Assignment.Entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private long id;
    private String name;
    private boolean inStock;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference  // Avoid infinite recursion by not serializing the 'category' field in the product
    private categories categories;

}
