package com.MCC53.springsecurity.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Item {
    
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "itemSequence")
    @SequenceGenerator(
            name = "itemSequence",
            sequenceName = "item_sequence",
            allocationSize = 1)
    private Integer id;
    
    @Column(
            name = "name",
            nullable = false)
    private String name;
    
    @Column(
            name = "quantity",
            nullable = false)
    private Integer quantity;
    
    @Column(
            name = "price",
            nullable = false)
    private Integer price;

    @Column(
            name = "image",
            nullable = true)
    @Lob
    private String image;
    
    @Column(
            name = "waranty",
            nullable = false)
    private Integer waranty;
    
    @Column(
            name = "extended_waranty",
            nullable = false)
    private Boolean extendedWaranty;

    @Column(
            name = "specification",
            nullable = false,
            columnDefinition = "TEXT")
    private String specification;
    
    //
    //Private Product product;
}
