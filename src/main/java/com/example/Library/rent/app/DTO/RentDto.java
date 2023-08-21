package com.example.Library.rent.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

    private Long id;
    private int rentTimeInDays;
    private double price;
}
