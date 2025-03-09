package com.example.e_com.service;

import com.example.e_com.model.Product;
import com.example.e_com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).get();
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImageType(image.getContentType());
        product.setImageName(image.getOriginalFilename());
        product.setImageData(image.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile image) throws IOException {
        product.setImageType(image.getContentType());
        product.setImageName(image.getOriginalFilename());
        product.setImageData(image.getBytes());
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchKeyword(String keyword) {
        return repo.searchProducts(keyword);
    }
}
