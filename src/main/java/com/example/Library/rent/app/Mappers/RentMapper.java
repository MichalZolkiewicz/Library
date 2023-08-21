package com.example.Library.rent.app.Mappers;

import com.example.Library.rent.app.Core.Rent;
import com.example.Library.rent.app.DTO.RentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentMapper {

    public Rent mapToRent(RentDto rentDto) {
        return new Rent(rentDto.getId(),
                        rentDto.getRentTimeInDays(),
                        rentDto.getPrice());
    }

    public RentDto mapToRentDto(Rent rent) {
        return new RentDto(rent.getId(),
                           rent.getRentTimeInDays(),
                           rent.getPrice());
    }

    public List<RentDto> mapToRentDtoList(final List<Rent> rentList) {
        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
