package com.example.Library.rent.app.Controllers;

import com.example.Library.rent.app.Core.Rent;
import com.example.Library.rent.app.DTO.RentDto;
import com.example.Library.rent.app.Facade.RentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/rent")
@RequiredArgsConstructor
public class RentController {

    private final RentFacade rentFacade;

    @GetMapping
    public List<RentDto> getAllRents() {
        return new ArrayList<>();
    }

    @GetMapping
    public RentDto getRent() {
        return new RentDto();
    }

    @PostMapping
    public Rent createRent() {
        return new Rent();
    }

    @PutMapping
    public Rent updateRent() {
        return new Rent();
    }

    @DeleteMapping
    public void deleteRent () {

    }
}
