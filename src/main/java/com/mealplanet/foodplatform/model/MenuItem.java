package com.mealplanet.foodplatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MenuItem")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private Long restaurantId;
}