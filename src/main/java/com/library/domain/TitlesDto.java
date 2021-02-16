package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class TitlesDto {

    private Long id;
    private String title;
    private String author;
    private int releaseYear;
    private List<Copy> copies;
}
