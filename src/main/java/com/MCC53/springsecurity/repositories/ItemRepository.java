
package com.MCC53.springsecurity.repositories;

import com.MCC53.springsecurity.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>{
    
}
