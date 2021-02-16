package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class RentalDto {

    private Long id;
    private Copy copy;
    private Users user;
    private LocalDate rentalDate;
    private LocalDate returnDate;
}
