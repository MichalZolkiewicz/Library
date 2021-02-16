package com.library.mapper;

import com.library.domain.Users;
import com.library.domain.UsersDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersMapper {

    public Users mapToUser(final UsersDto usersDto) {
        return new Users(usersDto.getFirstname(), usersDto.getLastname(), usersDto.getJoined());
    }

    public UsersDto mapToUserDto(final Users users) {
        return new UsersDto(users.getId(), users.getFirstname(), users.getLastname(), users.getJoined());
    }

    public List<UsersDto> mapToUsersDtoList(final List<Users> usersList) {
            return usersList.stream()
                    .map(this::mapToUserDto)
                    .collect(Collectors.toList());
    }
}
