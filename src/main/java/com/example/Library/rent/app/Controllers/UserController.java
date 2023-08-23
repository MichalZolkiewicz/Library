package com.example.Library.rent.app.Controllers;

import com.example.Library.rent.app.Core.User;
import com.example.Library.rent.app.DTO.UserDto;
import com.example.Library.rent.app.Facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return new ArrayList<>();
    }

    @GetMapping
    public UserDto getUser() {
        return new UserDto();
    }

    @PostMapping
    public User createUser() {
        return new User();
    }

    @PutMapping
    public User updateUser() {
        return new User();
    }

    @DeleteMapping
    public void deleteUser() {

    }

}

