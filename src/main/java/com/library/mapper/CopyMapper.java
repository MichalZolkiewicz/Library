package com.library.mapper;

import com.library.domain.Copy;
import com.library.domain.CopyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyMapper {

    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(copyDto.getStatus());
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(copy.getId(), copy.getStatus(), copy.getTitles());
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList) {
        return copyList.stream()
                .map(this::mapToCopyDto)
                .collect(Collectors.toList());
    }
}
