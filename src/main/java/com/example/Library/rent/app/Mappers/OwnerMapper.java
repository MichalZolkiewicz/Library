package com.example.Library.rent.app.Mappers;

import com.example.Library.rent.app.Core.Owner;
import com.example.Library.rent.app.DTO.OwnerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerMapper {

    public Owner mapToOwner(OwnerDto ownerDto) {
        return new Owner(ownerDto.getId(),
                         ownerDto.getName());
    }

    public OwnerDto mapToOwnerDto(Owner owner) {
        return new OwnerDto(owner.getId(),
                            owner.getName());
    }

    public List<OwnerDto> mapToOwnerDtoList(final List<Owner> ownerList) {
        return ownerList.stream()
                .map(this::mapToOwnerDto)
                .collect(Collectors.toList());
    }
}
