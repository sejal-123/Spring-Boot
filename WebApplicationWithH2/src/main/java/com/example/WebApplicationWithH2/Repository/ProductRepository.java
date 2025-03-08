package com.example.WebApplicationWithH2.Repository;

import com.example.WebApplicationWithH2.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
