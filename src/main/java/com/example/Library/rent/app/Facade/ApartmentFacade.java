package com.example.Library.rent.app.Facade;

import com.example.Library.rent.app.Core.Apartment;
import com.example.Library.rent.app.DTO.ApartmentDto;
import com.example.Library.rent.app.Mappers.ApartmentMapper;
import com.example.Library.rent.app.Repositories.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentFacade {

    private final ApartmentMapper apartmentMapper;
    private final ApartmentRepository apartmentRepository;

    public List<ApartmentDto> getAllApartments() {
        List<Apartment> apartments = apartmentRepository.findAll();
        return apartmentMapper.mapToApartmentDtoList(apartments);
    }

    public ApartmentDto getApartmentDto(final long apartmentId) {
        Apartment apartment = apartmentRepository.findById(apartmentId);
        return apartmentMapper.mapToApartmentDto(apartment);
    }

    public Long createApartment(ApartmentDto apartmentDto) {
        Apartment apartment = apartmentMapper.mapToApartment(apartmentDto);
        apartmentRepository.save(apartment);

        return apartment.getId();
    }

    public Long updateApartment(long apartmentId, double price) {
        Apartment apartment = apartmentRepository.findById(apartmentId);
        apartment.setPrice(price);

        Apartment updatedApartment = apartmentRepository.save(apartment);
        apartmentMapper.mapToApartmentDto(updatedApartment);
        return updatedApartment.getId();
    }

    public void deleteApartment(final long apartmentId) {
        apartmentRepository.deleteById(apartmentId);
    }
}
