
package com.MCC53.springsecurity.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    
    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private String type;
    
    @Lob
    private byte[] image;

    public Product(String name, String type, byte[] image) {
        this.name = name;
        this.type = type;
        this.image = image;
    }

////    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @OneToOne(mappedBy = "product")
//    @JoinColumn(
//            name = "item_id",
//            nullable = true)
//    private Item item;
   
}
