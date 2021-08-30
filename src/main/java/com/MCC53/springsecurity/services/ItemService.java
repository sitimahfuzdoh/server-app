
package com.MCC53.springsecurity.services;

import com.MCC53.springsecurity.models.Item;
import com.MCC53.springsecurity.repositories.ItemRepository;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    
    public void saveItemToDB(MultipartFile file, String name, int quantity,
             int price, int waranty, boolean extendedWaranty, String specification) {
        
        Item item = new Item();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a valid file");
        }
        try {
            item.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        item.setName(name);
        item.setQuantity(quantity);
        item.setPrice(price);
        item.setWaranty(waranty);
        item.setExtendedWaranty(extendedWaranty);
        item.setSpecification(specification);

        itemRepository.save(item);
    }

    public List<Item> getAll() {

        return itemRepository.findAll();

    }

    public Item getById(Integer id) {

        return itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Data Not Found"));
    }

    public Item create(Item item) {

        if (item.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data Already Exist");
        }
        return itemRepository.save(item);
    }

    public Item update(Integer id, Item item) {

        getById(id);
        item.setId(id);

        return itemRepository.save(item);
    }

    public Item delete(Integer id) {

        Item item = getById(id);

        itemRepository.deleteById(id);

        return item;
    }
}

