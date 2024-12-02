package com.Assignment.Entites;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categories_id")
    private long id;
    private String name;

    @OneToMany(mappedBy = "categories",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<products> product;

}
