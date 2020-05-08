package com.jasonraymond.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value= "SELECT p FROM Product p WHERE p.name LIKE '%' || :keyword || '%'" +
    " OR p.brand LIKE '%' || :keyword || '%'"
            + "OR p.madein LIKE '%' || :keyword || '%'"
            + "OR p.price LIKE '%' || :keyword || '%'"
    )
    List<Product> search(@Param("keyword") String keyword);
}
