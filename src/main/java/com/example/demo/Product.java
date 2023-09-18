package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "products")
@Data
@EntityListeners(AuditAtByListener.class)
public class Product extends AuditAtBy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
