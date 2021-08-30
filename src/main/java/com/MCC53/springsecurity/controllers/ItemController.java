
package com.MCC53.springsecurity.controllers;

import com.MCC53.springsecurity.models.Item;
import com.MCC53.springsecurity.services.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/item")
public class ItemController {
    
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    
    @GetMapping
    public ResponseEntity<List<Item>> getAll(){
        
        return new ResponseEntity(itemService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable ("id") int id){
        
        return new ResponseEntity(itemService.getById(id),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Item> create (@RequestBody Item item){
        
        return new ResponseEntity(itemService.create(item),HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Item> update (@PathVariable("id") int id,
            @RequestBody Item item){
        
        return new ResponseEntity(itemService.update(id, item), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Item> delete (@PathVariable ("id") int id){
        
        return new ResponseEntity(itemService.delete(id),HttpStatus.OK);
    }
}

