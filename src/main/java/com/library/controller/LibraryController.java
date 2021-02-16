package com.library.controller;

import com.library.domain.*;
import com.library.mapper.CopyMapper;
import com.library.mapper.RentalMapper;
import com.library.mapper.TitlesMapper;
import com.library.mapper.UsersMapper;
import com.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/library")
@RequiredArgsConstructor
public class LibraryController {

    private final DbService dbService;
    private final TitlesMapper titlesMapper;
    private final UsersMapper usersMapper;
    private final CopyMapper copyMapper;
    private final RentalMapper rentalMapper;

    @GetMapping(value = "getTitles")
    public List<TitlesDto> getAllTitles() {
        List<Titles> allTitles = dbService.getAllTitles();
        return titlesMapper.mapToTitlesDtoList(allTitles);
    }

    @GetMapping(value = "getUsers")
    public List<UsersDto> getAllUsers() {
        List<Users> allUsers = dbService.getAllUsers();
        return usersMapper.mapToUsersDtoList(allUsers);
    }

    @GetMapping(value = "getCopies")
    public List<CopyDto> getAllCopies() {
        List<Copy> allCopies = dbService.getAllCopies();
        return copyMapper.mapToCopyDtoList(allCopies);
    }

    @GetMapping(value = "getRentals")
    public List<RentalDto> getAllRentals() {
        List<Rental> allRentals = dbService.getAllRental();
        return rentalMapper.mapToRentalDtoList(allRentals);
    }

    @PostMapping(value = "addUser")
    public void addUser(@RequestBody UsersDto usersDto) {
        Users user = usersMapper.mapToUser(usersDto);
        dbService.saveUser(user);
    }

    @PostMapping(value = "addTitle")
    public void addTitle(@RequestBody TitlesDto titlesDto) {
        Titles title = titlesMapper.mapToTitles(titlesDto);
        dbService.saveTitle(title);
    }

    @PostMapping(value = "addCopy")
    public void addCopy(@RequestBody CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        dbService.saveCopy(copy);
    }

    @PutMapping(value = "updateCopyStatus")
    public CopyDto updateCopyStatus(@RequestBody CopyDto copyDto) {
        Long id = copyDto.getId();
        Copy copy = dbService.getCopy(id).get();
        copy.setStatus(copyDto.getStatus());

        Copy newCopyStatus = dbService.saveCopy(copy);
        return copyMapper.mapToCopyDto(newCopyStatus);
    }

    @PostMapping(value = "createRental")
    public void createRental(@RequestBody RentalDto rentalDto) {
        Rental rental = rentalMapper.mapToRental(rentalDto);
        dbService.saveRental(rental);
    }

    @DeleteMapping(value = "finishRental")
    public void finishRental(final Long id) {
        dbService.deleteRental(id);
    }

}
