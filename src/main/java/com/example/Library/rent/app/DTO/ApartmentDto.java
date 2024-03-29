package com.example.Library.rent.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentDto {

    private Long id;
    private String name;
    private double price;
    private double size;
    private String description;
}
