
package com.MCC53.springsecurity.repositories;

import com.MCC53.springsecurity.models.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    
}
