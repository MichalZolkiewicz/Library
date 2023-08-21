package com.example.Library.rent.app.Mappers;

import com.example.Library.rent.app.Core.Apartment;
import com.example.Library.rent.app.DTO.ApartmentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentMapper {

    public Apartment mapToApartment(ApartmentDto apartmentDto) {
        return new Apartment(apartmentDto.getId(),
                             apartmentDto.getName(),
                             apartmentDto.getPrice(),
                             apartmentDto.getSize(),
                             apartmentDto.getDescription());
    }

    public ApartmentDto mapToApartmentDto(Apartment apartment) {
        return new ApartmentDto(apartment.getId(),
                                apartment.getName(),
                                apartment.getPrice(),
                                apartment.getSize(),
                                apartment.getDescription());
    }

    public List<ApartmentDto> mapToApartmentDtoList(final List<Apartment> apartmentList) {
        return apartmentList.stream()
                .map(this::mapToApartmentDto)
                .collect(Collectors.toList());
    }
}
