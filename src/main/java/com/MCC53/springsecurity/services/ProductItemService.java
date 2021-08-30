package com.MCC53.springsecurity.services;

import com.MCC53.springsecurity.models.ProductItem;
import com.MCC53.springsecurity.repositories.ProductItemRepository;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductItemService {

    @Autowired
    private ProductItemRepository productItemRepository;

    public void saveProductToDB(MultipartFile file, String name, String description,
            int price) {
        ProductItem p = new ProductItem();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.setDescription(description);

        p.setName(name);
        p.setPrice(price);

        productItemRepository.save(p);
    }

    public List<ProductItem> getAllProduct() {
        return productItemRepository.findAll();
    }

    public void deleteProductById(Long id) {
        productItemRepository.deleteById(id);
    }

    public void chageProductName(Long id, String name) {
        ProductItem p = new ProductItem();
        p = productItemRepository.findById(id).get();
        p.setName(name);
        productItemRepository.save(p);
    }

    public void changeProductDescription(Long id, String description) {
        ProductItem p = new ProductItem();
        p = productItemRepository.findById(id).get();
        p.setDescription(description);
        productItemRepository.save(p);
    }

    public void changeProductPrice(Long id, int price) {
        ProductItem p = new ProductItem();
        p = productItemRepository.findById(id).get();
        p.setPrice(price);
        productItemRepository.save(p);
    }
}
