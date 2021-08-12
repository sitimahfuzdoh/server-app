/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MCC53.springsecurity.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "privilege")
public class Privilege {
    
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Column( name = "id")
    private Integer id;
    
    @Column( name = "name", nullable = false)
    private String name;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany (mappedBy = "privileges")
    private List<Role> roles ;
    
    
}
