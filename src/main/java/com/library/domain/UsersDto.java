package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsersDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String joined;
}
