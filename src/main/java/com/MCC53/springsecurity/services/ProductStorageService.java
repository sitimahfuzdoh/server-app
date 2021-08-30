package com.MCC53.springsecurity.services;

import com.MCC53.springsecurity.models.Product;
import com.MCC53.springsecurity.repositories.ProductRepository;
import java.io.IOException;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ProductStorageService {

    @Autowired
    private ProductRepository productRepository;

    
    public Product store(MultipartFile file) throws IOException {
        
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Product product = new Product(fileName, file.getContentType(), file.getBytes());

        return productRepository.save(product);
    }

    public Product getFile(int id) {

        return productRepository.findById(id).get();
    }
    
    public Stream<Product> getAllFiles() {
    
        return productRepository.findAll().stream();
  }
}
