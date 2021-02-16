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
        Copy copy = copyMapper.mapToCopy(copyDto);
        Copy newCopyStatus = dbService.saveCopy(copy);
        return copyMapper.mapToCopyDto(newCopyStatus);
    }

    @GetMapping(value = "getCopies")
    public List<CopyDto> getTitlesCopiesAmount(@RequestBody TitlesDto titlesDto) {
        Titles title = titlesMapper.mapToTitles(titlesDto);
        List<Copy> titleCopies = title.getCopies();
        return copyMapper.mapToCopyDtoList(titleCopies);
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
