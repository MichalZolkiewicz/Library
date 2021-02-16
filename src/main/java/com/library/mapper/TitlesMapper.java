package com.library.mapper;

import com.library.domain.Copy;
import com.library.domain.CopyDto;
import com.library.domain.Titles;
import com.library.domain.TitlesDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitlesMapper {

    public Titles mapToTitles(final TitlesDto titlesDto) {
        return new Titles(titlesDto.getTitle(), titlesDto.getAuthor(), titlesDto.getReleaseYear());
    }

    public TitlesDto mapToTitlesDto(final Titles titles) {
        return new TitlesDto(titles.getId(), titles.getTitle(), titles.getAuthor(), titles.getReleaseYear(), titles.getCopies());
    }

    public List<TitlesDto> mapToTitlesDtoList(final List<Titles> titlesList) {
        return titlesList.stream()
                .map(this::mapToTitlesDto)
                .collect(Collectors.toList());
    }
}
