package com.example.Library.rent.app.Controllers;

import com.example.Library.rent.app.Core.Apartment;
import com.example.Library.rent.app.DTO.ApartmentDto;
import com.example.Library.rent.app.Facade.ApartmentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/apartment")
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentFacade apartmentFacade;

    @GetMapping
    public List<ApartmentDto> getAllApartments() {
        return new ArrayList<>();
    }

    @GetMapping
    public ApartmentDto getApartment() {
        return new ApartmentDto();
    }

    @PostMapping
    public Apartment createApartment() {
        return new Apartment();
    }

    @PutMapping
    public Apartment updateApartment() {
        return new Apartment();
    }

    @DeleteMapping
    public void deleteApartment() {

    }
}
