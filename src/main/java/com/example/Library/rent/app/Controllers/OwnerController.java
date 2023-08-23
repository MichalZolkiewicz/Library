package com.example.Library.rent.app.Controllers;

import com.example.Library.rent.app.Core.Owner;
import com.example.Library.rent.app.DTO.OwnerDto;
import com.example.Library.rent.app.Facade.OwnerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/owner")
@RequiredArgsConstructor
public class OwnerController {

    final private OwnerFacade ownerFacade;

    @GetMapping
    public List<OwnerDto> getAllOwners(){
        return new ArrayList<>();
    }

    @GetMapping
    public OwnerDto getOwner() {
        return new OwnerDto();
    }

    @PostMapping
    public Owner addOwner() {
        return new Owner();
    }

    @PutMapping
    public Owner updateOwner() {
        return new Owner();
    }

    @DeleteMapping
    public void deleteOwner() {

    }
}
