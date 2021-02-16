package com.library.mapper;

import com.library.domain.Rental;
import com.library.domain.RentalDto;
import com.library.domain.Titles;
import com.library.domain.TitlesDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalMapper {

    public Rental mapToRental(final RentalDto rentalDto) {
        return new Rental(rentalDto.getId(), rentalDto.getCopy(), rentalDto.getUser(), rentalDto.getRentalDate(), rentalDto.getReturnDate());
    }

    public RentalDto mapToRentalDto(final Rental rental) {
        return new RentalDto(rental.getId(), rental.getCopy(), rental.getUser(), rental.getRentalDate(), rental.getReturnDate());
    }

    public List<RentalDto> mapToRentalDtoList(final List<Rental> rentalList) {
        return rentalList.stream()
                .map(this::mapToRentalDto)
                .collect(Collectors.toList());
    }
}
