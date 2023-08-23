package com.example.Library.rent.app.Controllers;

import com.example.Library.rent.app.DTO.ApartmentDto;
import com.example.Library.rent.app.Facade.ApartmentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/apartment")
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentFacade apartmentFacade;

    @GetMapping(value = "/getApartments")
    public List<ApartmentDto> getAllApartments() {
        return apartmentFacade.getAllApartments();
    }

    @GetMapping(value = "/getApartment/{id}")
    public ApartmentDto getApartment(@PathVariable Long apartmentId) {
        return apartmentFacade.getApartmentDto(apartmentId);
    }

    @PostMapping(value = "/createApartment")
    public Long createApartment(@RequestBody ApartmentDto apartmentDto) {
        return apartmentFacade.createApartment(apartmentDto);
    }

    @PutMapping(value = "/updateApartment")
    public Long updateApartment(@RequestParam Long apartmentId, @RequestParam Double price) {
        return apartmentFacade.updateApartment(apartmentId, price);
    }

    @DeleteMapping(value = "/deleteApartment/{id}")
    public void deleteApartment(@PathVariable Long apartmentId) {
        apartmentFacade.deleteApartment(apartmentId);
    }
}
